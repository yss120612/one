package com.yss1.one;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;
import com.yss1.one.dao.AS400Dao;
import com.yss1.one.models.Man;
import com.yss1.one.util.PdfFactory;
import com.yss1.one.util.Utils;

@Service
@EnableScheduling
public class SheduleBaseScan {
@Value("${scan_timeout}")
private int timeout;	
private int counter=0;

@Autowired
ApplicationContext ctx;
DataSource pgDS;

@PostConstruct
public void init() {
	pgDS=(DataSource)ctx.getBean("postgressDS");
}


@Scheduled(fixedRate = 120000)
private void run()
{
	//if (pgDS==null) return;
	//pgDS=(DataSource)ctx.getBean("postgressDS");
	PdfFactory doc=new PdfFactory();
	String res="";
//	try {
//		res=Utils.bytes2HexStr(doc.makeDocument1(counter++));
//	} catch (DocumentException | IOException e) {
//		e.printStackTrace();
//	}
	if (pgDS!=null) {
    //JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
    
    //PreparedStatementCreator psc = (PreparedStatementCreator) new PreparedStatementCreatorFactory("update public.spravka set szi_new=? where id=1");
    
    System.out.println("Tut"+counter++);
    try {
    //PreparedStatement pst=createPreparedStatement(ds.getConnection());
    	
    HashMap<Integer,String> mans= new HashMap<>();
    Connection conn=pgDS.getConnection();
    Statement stmt= conn.createStatement();
    String sql="select id,Vc_ins from  public.spravka where ts_a is null";
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()) {
    	mans.put(rs.getInt("id"), rs.getString("Vc_ins"));
    }
    rs.close();
    stmt.close();
    PreparedStatement pst;
    AS400Dao as400= new AS400Dao(); 
    Man man;
    String result;
    for (Map.Entry<Integer,String> pair: mans.entrySet())
    {
     //System.out.println("id="+pair.getKey()+" value="+pair.getValue());
    result="";	
    man=as400.load(pair.getValue(),result);	
    if (result.isEmpty() || man==null)
    {
    res=Utils.bytes2HexStr(doc.makeErrorDocument(pair.getValue(),result));
    }
    else
    {
    res=Utils.bytes2HexStr(doc.makeDocument(man));	
    }
    pst=conn.prepareStatement("update public.spravka set szi_new=?,raschet=?, ts_a=TIMESTAMP '"+Utils.getFormattedDate4sql(new Date())+"' where id="+pair.getKey());
    
    pst.setBinaryStream(1, new ByteArrayInputStream(res.getBytes()), res.length());
    //res=Utils.bytes2HexStr(doc.makeErrorDocument("RASCHET FOR:"+pair.getValue()));
    pst.setBinaryStream(2, new ByteArrayInputStream(res.getBytes()), res.length());
    //pst.setString(2, Utils.getFormattedDate4sql(new Date()));
    //pst.setInt(3,pair.getKey());
    System.out.println(pst.toString());
    //System.out.println(pst.);
    pst.executeUpdate();
    pst.close();
    }
    
    } catch (Exception e) {
		e.printStackTrace();
	}
	}
	else
	{
		System.out.println("ds on shedule is null");
	}
}
}
