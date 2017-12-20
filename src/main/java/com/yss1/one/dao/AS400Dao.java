package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.yss1.one.calc.RkCalculator;
import com.yss1.one.models.Man;
import com.yss1.one.models.Platej;
import com.yss1.one.models.Staj;
import com.yss1.one.models.Vsnos;
import com.yss1.one.util.ApplicationContextUtil;
import com.yss1.one.util.PerfMeter;
import com.yss1.one.util.Twix;
import com.yss1.one.util.Utils;



public class AS400Dao {
	 private String fieldCsp;
	 private String fieldCtp;
	 private int dateSpos;
	 private int dateFpos;
	 private int vidDeyat;
	 private int naimOrg;
	// SingleConnectionDataSource sds;
	 private String err;
	 PerfMeter meter;
	 private List<Twix<String,String>> list1; 
	 private List<Twix<String,String>> list2;
	 
	 
	public AS400Dao() {
		meter=(PerfMeter)ApplicationContextUtil.getApplicationContext().getBean(PerfMeter.class);
	}
	 	 
	public Man load(String snils) throws SQLException
	{
		setErr("");
		Man man=new Man();
		snils=Utils.rawSNILS(snils);
		Integer count;
		if (snils.isEmpty())
		{
			setErr("Пустой или не правильный снилс!");
			return null;
		}
		
		//sds=(SingleConnectionDataSource)ApplicationContextUtil.getApplicationContext().getBean("as400DataSource");
		//JdbcTemplate jt=new JdbcTemplate((SingleConnectionDataSource)ApplicationContextUtil.getApplicationContext().getBean("as400DataSource"),true);
		JdbcTemplate jt=new JdbcTemplate((DataSource)ApplicationContextUtil.getApplicationContext().getBean("as400DataSource"),true);
		String place="";
		meter.init();
		meter.start();
		try
		{
		//получаем человека по СНИЛСу	
		place="18A";	
		jt.update("call OPFRSOFT.PFRBAT0201('R002000018/"+snils+"/')");
		place="18B";
		count=jt.queryForObject("select count(*) FROM QTEMP.R002000018",Integer.class);
		if (count<1)
		{
			jt.getDataSource().getConnection().close();
			setErr("Снилс "+snils+" не найден!");
			return null;
		}

		man=jt.queryForObject("select * FROM QTEMP.R002000018",manRowMapper);
		meter.measure("AS400 18");
		
		
		
		
		//получаем стаж по данным работодателя
		fieldCtp="ctpext";
		fieldCsp="cspext";
		dateSpos=7;
		dateFpos=8;
		naimOrg=4;
		vidDeyat=0;
		place="16A";
		meter.start();
		jt.update("call OPFRSOFT.PFRBAT0201('R002000016/"+snils+"/')");
		place="16B";
		man.setStaj(jt.query("select * FROM QTEMP.R002000016",stajRowMapper));
		
		//получаем стаж по данным конвертации
		jt.update("call OPFRSOFT.PFRBAT0201('R002000289/"+snils+"/')");
		count=jt.queryForObject("select count(*) FROM QTEMP.R002000289", Integer.class);
		meter.measure("AS400 16");
		
		if (count>0)
		{
			fieldCtp="ctpcod";
			fieldCsp="cspcod";
			dateSpos=13;
			dateFpos=14;
			vidDeyat=7;
			naimOrg=8;
			place="291A";
			meter.start();
			jt.update("call OPFRSOFT.PFRBAT0201('R002000291/"+snils+"/')");
			place="291B";
			man.setStajKonv(jt.query("select * FROM QTEMP.R002000291",stajRowMapper));
			meter.measure("AS400 291");
		}
		
		
		//зарплата за 2000-2002 гг.
		place="14A";
		meter.start();
		jt.update("call OPFRSOFT.PFRBAT0201('R002000014/"+snils+"/')");
		place="14B";
		man.setPlateg20002001(jt.query("select * FROM QTEMP.R002000014 where ctmcod like('2000') or ctmcod like('2001')",platejRowMapper));
		place="14C";
		list1=jt.query("select entnmb, MAX(entnam) entnam FROM QTEMP.R002000014 GROUP BY entnmb",nameRowMapper);
		meter.measure("AS400 14");
		
		
		//взносы
		place="15A";
		meter.start();
		jt.update("call OPFRSOFT.PFRBAT0201('R002000015/"+snils+"/')");
		place="15B";
		man.setVsnosy(jt.query("select * FROM QTEMP.R002000015",vsnosRowMapper));
		place="15C";
		list2=jt.query("SELECT entnmb, MAX(entnam) entnam FROM QTEMP.R002000015  GROUP BY entnmb",nameRowMapper);
		meter.measure("AS400 15");
		
		//уточнения по видом деятельности, указанному во взносах
		meter.start();
		place="173A";
		jt.update("call OPFRSOFT.PFRBAT0201('R002000173/"+snils+"/')");
		place="173B";
		List<VsnosHelper> vhl = jt.query("select * FROM QTEMP.R002000173",vsnosHelperRowMapper);
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
		meter.measure("AS400 173");
		
		
		}
		
		catch(Exception ex)
		{
			//sds.getConnection().close();
			jt.getDataSource().getConnection().close();
			setErr("Ошибка запроса к AS400! "+place+"<br>"+ex.getMessage());
			return null;
		}

		Map<String,String> listAll=new HashMap<>();
		
		if (list1!=null) {
			for (Twix<String,String> twx: list1) {
			if(listAll.containsKey(twx.getKey())) {
				listAll.remove(twx.getKey());
			}
			listAll.put(twx.getKey(),twx.getVal());
			}
		}
		if (list2!=null) {
			for (Twix<String,String> twx: list2) {
			if(listAll.containsKey(twx.getKey())) {
				listAll.remove(twx.getKey());
			}
			listAll.put(twx.getKey(),twx.getVal());
			}
		}
		
		
		for (Staj st:man.getStaj()) {
			if (st.getFlag()==1 && listAll.containsKey(st.getRegNumb())) {
				st.setPredprName(listAll.get(st.getRegNumb()));
				st.setFlag(0);
			}
		}
		
		
		
		man.calcPens();
		jt.getDataSource().getConnection().close();
		return man;
	}
	
	
	private RowMapper<Staj> stajRowMapper = new RowMapper<Staj>() {
		public Staj mapRow(ResultSet rs, int rowNum) throws SQLException {
			if (rs.getString(dateSpos)==null||rs.getString(dateFpos)==null) return null;
			Staj staj = new Staj();
			if (vidDeyat==0)
			{
				staj.setVidDeyat("РАБОТА");	
				staj.setRegNumb(rs.getString(naimOrg));
				staj.setFlag(1);
			}
			else
			{
				staj.setPredprName(rs.getString(naimOrg));
				staj.setVidDeyat(rs.getString(vidDeyat));
				staj.setFlag(0);
			}
			staj.setPredprName(rs.getString(naimOrg));
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
			if (rs.getString("asr")==null || rs.getString("asr").isEmpty()) return null;
			Vsnos vsnos = new Vsnos();
			vsnos.setDptcod(rs.getInt("dptcod"));
			vsnos.setDcinmb(rs.getLong("dcinmb"));
			vsnos.setCtmcod(rs.getString("ctmcod"));
			vsnos.setRegNumb(rs.getString("entnmb"));
			vsnos.setAsr(Float.parseFloat(rs.getString("asr").replace(",",".")));
			vsnos.setCprext(rs.getString("cprext"));
			return vsnos;
		}
	};
	
	private RowMapper<Twix<String,String>> nameRowMapper = new RowMapper<Twix<String,String>>() {
	public Twix<String,String> mapRow(ResultSet rs, int rowNum) throws SQLException {
		String s1=rs.getString("entnmb");
		String s2=rs.getString("entnam");
		return new Twix<String,String>(s1==null?"":s1.trim(),s2==null?"":s2.trim());
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
			if (rs.getString("ctmbeg")==null || rs.getString("ctmend")==null) return null;
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
			GregorianCalendar gc=new GregorianCalendar();
			gc.setTime(m.getBirthDay().getTime());
			gc.add(GregorianCalendar.YEAR, m.getSex().contains("Ж")?55:60);
			m.setDatePrav(gc);
			m.setLgota(0);
			return m;
		}
	};

	
	
	
	private String res;
	public String getRes() {
		return res;
	}

	public String getErr() {
		return err;
	}

	public void setErr(String err) {
		this.err = err;
	}
}
