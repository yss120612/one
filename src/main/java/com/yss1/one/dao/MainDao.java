package com.yss1.one.dao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	PdfFactory pdfFactory;

	private String error;
	
	public String getError() {
		return error;
	}

private String res;
	
	public String getRes() {
		return res;
	}
	
	public Man calculate(String snils, long id) throws DocumentException, IOException {
		PreparedStatement pst;
		AS400Dao as400 = new AS400Dao();
		String res = "";
		String sql = "";
		Man man = null;
		Connection conn = null;
		snils=Utils.formatSNILS(snils);
		try {
			conn = pgDS.getConnection();
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
		if (man == null) {
			res = Utils.bytes2HexStr(pdfFactory.makeErrorDocument(snils, as400.getErr()));
			if (id == 0) {
				sql = "insert into public.spravka (vc_client,vc_ins,ts_q,ts_a,szi_new,raschet,pens) values ('"
						+ WebUtils.getLogin() + "','" + snils + "','" + now + "','" + now + "',?,?,0)";
			} else {
				sql = "update public.spravka set szi_new=?,raschet=?, ts_a=TIMESTAMP '" + now + "', pens=0 where id="
						+ id;
			}
		} else {
			res = Utils.bytes2HexStr(pdfFactory.makeDocument(man));
			if (id == 0) {
				sql = "insert into public.spravka (vc_client,vc_ins,ts_q,ts_a,szi_new,raschet,pravo,pens) values ('"
						+ WebUtils.getLogin() + "','" + snils + "','" + now + "','" + now + "',?,?,Date('"
						+ Utils.getFormattedDate4sql2(man.getDatePravDate()) + "')," + man.getSumm() + ")";
			} else {
				sql = "update public.spravka set szi_new=?,raschet=?, ts_a=TIMESTAMP '" + now + "', pens="
						+ man.getSumm() + ",pravo=Date('" + Utils.getFormattedDate4sql2(man.getDatePravDate())
						+ "') where id=" + id;
			}
		}

		try {
			pst = conn.prepareStatement(sql);
			pst.setBinaryStream(1, new ByteArrayInputStream(res.getBytes()), res.length());
			pst.setBinaryStream(2, new ByteArrayInputStream(res.getBytes()), res.length());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return man;
	}

}
