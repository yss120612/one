package com.yss1.one.dao;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import com.itextpdf.text.DocumentException;
import com.yss1.one.models.Man;
import com.yss1.one.util.PdfFactory;
import com.yss1.one.util.Utils;
import com.yss1.one.util.WebUtils;

//расчет пенсии клиента, занесение в BD расчитанной информации  автора запроса
@Repository
public class MainDao {
	@Autowired
	private DataSource pgDS;

	
	private JdbcTemplate pgDT;
	
	@PostConstruct
	public void init() {
		pgDT=new JdbcTemplate(pgDS);
	}

	
	@Autowired
	PdfFactory pdfFactory;
	
	@Autowired
	SpravkaDao sprDao;

	private String error;
	
	public String getError() {
		return error;
	}

private String res;
private long id;	
	public long getId() {
	return id;
}

	public String getRes() {
		return res;
	}
	
	public Man calculate(String snils, long id) throws DocumentException, IOException {
		//PreparedStatement pst;
		AS400Dao as400 = new AS400Dao();
		String res = "";
		String resr = "";
		
		Man man = null;
		//Connection conn = null;
		snils=Utils.formatSNILS(snils);
		try {
			//conn = pgDS.getConnection();
			man = as400.load(snils);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (!snils.isEmpty())
		{
		     error=as400.getErr();
		}
		else
		{
			 error = "Некорректный СНИЛС!"; 
		}
		
		
		
		
		
		/*
		 * id bigint NOT NULL DEFAULT nextval('spravka_id_seq'::regclass),
		 * vc_client * character varying(12) COLLATE pg_catalog."default" NOT NULL,
		 * vc_ins character varying(14) COLLATE pg_catalog."default" NOT NULL, 
		 * ts_q timestamp without time zone NOT NULL,
		 * ts_a timestamp without time zone, 
		 * szi_new bytea, 
		 * raschet bytea, 
		 * pravo date, 
		 * pens numeric(15,2),
		 */
		String now = Utils.getFormattedDate4sql(new Date());
		
		if (id==0) {
			id=sprDao.insertAndGetId(now, snils);
		}
		
		this.id=id;
		
		

		
		
		if (man == null) {
			res = Utils.bytes2HexStr(pdfFactory.makeErrorDocument(snils, as400.getErr()));
			resr=res;
		} else {
			//pdfFactory.makeExplanation(man,id);
			res = Utils.bytes2HexStr(pdfFactory.makeDocument(man));
			resr = Utils.bytes2HexStr(pdfFactory.makeExplanation(man,id));
//			sql = "update public.spravka set szi_new=?,raschet=?, ts_a=TIMESTAMP '" + now + "', pens="
//						+ man.getSumm() + ",pravo=Date('" + Utils.getFormattedDate4sql2(man.getDatePravDate())+ "'), fio='"+(man.getFamily()+" "+man.getName()+" "+man.getOtch())+"' where id=" + id;
		}

//		PreparedStatementCreator psc=new PreparedStatementCreator() {
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				String sql = "update public.spravka set szi_new=?,raschet=?, ts_a=TIMESTAMP '?', pens=? ,pravo=Date('?'), fio='?' where id=?";
//				PreparedStatement  ps=con.prepareStatement(sql);
//				
//				ps.setBinaryStream(1, new ByteArrayInputStream(res.getBytes()));
//				ps.setBinaryStream(2, new ByteArrayInputStream(resr.getBytes()));
//				ps.setString(3, now);
//				ps.setFloat(4, man.getSumm());
//				ps.setString(5,Utils.getFormattedDate4sql2(man.getDatePravDate()) );
//				ps.setString(6,man.getFamily()+" "+man.getName()+" "+man.getOtch());
//				ps.setLong(7, id);
//				return ps;
//			}
//		};
//		pgDT.update(psc);
		
		
		return man;
	}

}
