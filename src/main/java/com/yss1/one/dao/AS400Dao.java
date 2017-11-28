package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.yss1.one.models.Man;
import com.yss1.one.models.Platej;
import com.yss1.one.models.Staj;
import com.yss1.one.models.Vsnos;
import com.yss1.one.util.ApplicationContextUtil;
import com.yss1.one.util.Utils;



public class AS400Dao {
	
	 private Man man;
	 private String fieldCsp;
	 private String fieldCtp;
	 private int dateSpos;
	 private int dateFpos;
	// SingleConnectionDataSource sds;
	 
	
	 	 
	public String load(String snils) throws SQLException
	{
		snils=Utils.rawSNILS(snils);
		
		if (snils.isEmpty())
		{
			return "Пустой или не правильный снилс!";
		}
		
		//sds=(SingleConnectionDataSource)ApplicationContextUtil.getApplicationContext().getBean("as400DataSource");
		JdbcTemplate jt=new JdbcTemplate((SingleConnectionDataSource)ApplicationContextUtil.getApplicationContext().getBean("as400DataSource"),true);
		
		try
		{
			
		jt.update("call OPFRSOFT.PFRBAT0201('R002000018/"+snils+"/')");
		man=jt.queryForObject("select * FROM QTEMP.R002000018",manRowMapper);
		if (man==null) {
			//sds.getConnection().close();
			jt.getDataSource().getConnection().close();
			return "Снилс "+snils+" не найден!";
		}
		
		int age=60;
		if (man.getSex().contains("Ж")) {
			age=55;
		}
		
		GregorianCalendar gc=new GregorianCalendar();
		gc=man.getBirthDay();
		gc.add(GregorianCalendar.YEAR, age);
		man.setDatePrav(gc);
		man.setLgota(0);
		
		fieldCtp="ctpext";
		fieldCsp="cspext";
		dateSpos=7;
		dateFpos=8;
		jt.update("call OPFRSOFT.PFRBAT0201('R002000016/"+snils+"/')");
		man.setStaj(jt.query("select * FROM QTEMP.R002000016",stajRowMapper));
		
		jt.update("call OPFRSOFT.PFRBAT0201('R002000289/"+snils+"/')");
		int count=jt.queryForObject("select count(*) FROM QTEMP.R002000289", Integer.class);
		
		if (count>0)
		{
			fieldCtp="ctpcod";
			fieldCsp="cspcod";
			dateSpos=13;
			dateFpos=14;
			jt.update("call OPFRSOFT.PFRBAT0201('R002000291/"+snils+"/')");
			man.setStajKonv(jt.query("select * FROM QTEMP.R002000291",stajRowMapper));
			//.println("HEREEEE Konv="+man.getStajKonv().size() +" Staj="+man.getStaj().size());
		}
		
		
		//зарплата за 2000-2002 гг.
		jt.update("call OPFRSOFT.PFRBAT0201('R002000014/"+snils+"/')");
		man.setPlateg20002001(jt.query("select * FROM QTEMP.R002000014 where ctmcod like('2000') or ctmcod like('2001')",platejRowMapper));

		//взносы
		jt.update("call OPFRSOFT.PFRBAT0201('R002000015/"+snils+"/')");
		man.setVsnosy(jt.query("select * FROM QTEMP.R002000015",vsnosRowMapper));
		
		//уточнения по видом деятельности, указанному во взносах
		jt.update("call OPFRSOFT.PFRBAT0201('R002000173/"+snils+"/')");
		List<VsnosHelper> vhl = (jt.query("select * FROM QTEMP.R002000173",vsnosHelperRowMapper));
		
		for (Vsnos vs: man.getVsnosy())
		{
			if (vs.getCprext()==null||vs.getCprext().isEmpty())
			{
				for(VsnosHelper vh: vhl)
				{
					if (vh.getDptcod()==vs.getDptcod() && vh.getDcinumb()==vs.getDcinmb() && vh.getCprext()!=null)
					{
						vs.setCprext(vh.getCprext());
						break;
					}
				}
			}
		}
		
		
		
		}
		
		catch(Exception ex)
		{
			//sds.getConnection().close();
			jt.getDataSource().getConnection().close();
			return "Ошибка запроса к AS400!"+"\n"+ex.getMessage();
		}
		res=man.getFamily()+" "+man.getName()+" "+man.getOtch()+" "+man.getSex()+" "+man.getFormattedBirthday()+" "+man.getSNILS()+"<br>";
		man.calcStaj();
		res=res+man.getPeriod().toString()+"<br>"+"Platejes length="+man.getPlateg20002001().size()+"<br>";
		res+=man.res;
		jt.getDataSource().getConnection().close();
		return "";
	}
	
	
	private RowMapper<Staj> stajRowMapper = new RowMapper<Staj>() {
		public Staj mapRow(ResultSet rs, int rowNum) throws SQLException {
			Staj staj = new Staj();
			staj.setVidDeyat(rs.getString(7));
			staj.setStartDate(Utils.makeDate(rs.getString(dateSpos),"\\."));
			staj.setEndDate(Utils.makeDate(rs.getString(dateFpos),"\\."));
			staj.setCggext(rs.getString("cggext"));
			staj.setCspext(rs.getString(fieldCsp));
			staj.setCtpext(rs.getString(fieldCtp));
			staj.setCwcext(rs.getString("cwcext"));
			staj.setDopctpext(rs.getString("dopctpext"));
			staj.setDopcspext(rs.getString("dopcspext"));
			return staj;
		}
	};
	
	
	private RowMapper<Vsnos> vsnosRowMapper = new RowMapper<Vsnos>() {
		public Vsnos mapRow(ResultSet rs, int rowNum) throws SQLException {
			Vsnos vsnos = new Vsnos();
			vsnos.setDptcod(rs.getInt("dptcod"));
			vsnos.setDcinmb(rs.getLong("dcinmb"));
			vsnos.setCtmcod(rs.getString("ctmcod"));
			vsnos.setAsr(Float.parseFloat(rs.getString("asr").replace(",",".")));
			vsnos.setCprext(rs.getString("cprext"));
			return vsnos;
		}
	};
	
	//вспомогательный класс для уточнения видов деятельности
	private class VsnosHelper {
		private long dcinumb;
		private int dptcod;
		private String cprext;
		public long getDcinumb() {
			return dcinumb;
		}
		public int getDptcod() {
			return dptcod;
		}
		public String getCprext() {
			return cprext;
		}
		public VsnosHelper(int dptcod, long dcinumb, String cprext) {
			this.dcinumb = dcinumb;
			this.dptcod = dptcod;
			this.cprext = cprext;
		}
	}
	
	private RowMapper<VsnosHelper> vsnosHelperRowMapper = new RowMapper<VsnosHelper>() {
		public VsnosHelper mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new VsnosHelper(rs.getInt(1),rs.getLong(2),rs.getString(12));
		}
	};
	
	
	private RowMapper<Platej> platejRowMapper = new RowMapper<Platej>() {
		public Platej mapRow(ResultSet rs, int rowNum) throws SQLException {
			Platej platej = new Platej();
			platej.setdStart(Utils.makeDate(rs.getString("ctmbeg"),"\\."));
			platej.setdEnd(Utils.makeDate(rs.getString("ctmend"),"\\."));
			String [] astr=rs.getString("dcinmb").split("-");
			if (astr.length>0 && astr[0].length()>3)
			{
				String ss=astr[0];
				platej.setRaion(Integer.parseInt(ss.substring(ss.length()-3)));
				platej.setRegion(Integer.parseInt(ss.substring(0,ss.length()-3)));	
			}
			platej.setSumma(rs.getFloat("pfssum"));
			return platej;
		}
	};
	
	private RowMapper<Man> manRowMapper = new RowMapper<Man>() {
		public Man mapRow(ResultSet rs, int rowNum) throws SQLException {
			Man m = new Man();
			m.setBirthDayDate(Utils.makeDate(rs.getString("prnbrd"),"\\."));
			m.setFio(rs.getString("fio"));
			m.setSNILS(rs.getString("insnmb"));
			m.setSex(rs.getString("prnsex"));
			return m;
		}
	};

	
	
	
	private String res;
	public String getRes() {
		return res;
	}
}
