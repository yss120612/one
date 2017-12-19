package com.yss1.one.dao;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.itextpdf.text.DocumentException;
import com.yss1.one.models.Man;
import com.yss1.one.util.PdfFactory;
import com.yss1.one.util.Utils;

//расчет пенсии клиента, занесение в BD расчитанной информации  автора запроса
@Repository
public class MainDao {
	@Autowired
	private DataSource pgDS;

	
	@Autowired
	PdfFactory pdfFactory;
	
	@Autowired
	SpravkaDao sprDao;

	@Autowired
	 ManDao manDao;
	
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
		AS400Dao as400 = new AS400Dao();
		String res = "";
		String resr = "";
		String sql;
		Man man = null;
		JdbcTemplate pgDT=new JdbcTemplate(pgDS);
		snils = Utils.formatSNILS(snils);
		try {
			man = as400.load(snils);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (!snils.isEmpty()) {
			error = as400.getErr();
		} else {
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
			Long idd=sprDao.insertAndGetId(now, snils);
			if (idd!=null && idd>0) id=idd;
		}
		
		this.id=id;
		
		if (man == null && id>0) {
			res = Utils.bytes2HexStr(pdfFactory.makeErrorDocument(snils, as400.getErr()));
			resr=res;
			sql = "update public.spravka set szi_new=?,raschet=?, ts_a=TIMESTAMP '" + now + "', pens=0  where id=" + id;
		} else {
			manDao.save(man, id);
			res = Utils.bytes2HexStr(pdfFactory.makeDocument(man));
			resr = Utils.bytes2HexStr(pdfFactory.makeExplanation(man,id));
			sql = "update public.spravka set szi_new=?,raschet=?, ts_a=TIMESTAMP '" + now + "', pens="
					+ man.getSumm() + ",pravo=Date('" + Utils.getFormattedDate4sql2(man.getDatePravDate())+ "'), fio='"+(man.getFamily()+" "+man.getName()+" "+man.getOtch())+"' where id=" + id;
		}
		
		PSC psc=new PSC(sql,res,resr);
		
		pgDT.update(psc);
				
		return man;
	}
	
	private class PSC implements PreparedStatementCreator{
		String sql;
		String res1;
		String res2;
		public PSC(String sq,String r1,String r2) {
			sql=sq;
			res1=r1;
			res2=r2;
		}

		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement  ps=con.prepareStatement(sql);
			ps.setBinaryStream(1, new ByteArrayInputStream(res1.getBytes()));
			ps.setBinaryStream(2, new ByteArrayInputStream(res2.getBytes()));
			return ps;
		}
	}
}
