package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yss1.one.models.Man;
import com.yss1.one.models.Platej;
import com.yss1.one.models.Staj;
import com.yss1.one.models.Vsnos;
import com.yss1.one.util.Utils;

@Repository
public class ManDao {
	@Autowired
	private DataSource pgDS;
	
	private JdbcTemplate pgDT;
	
	@PostConstruct
	public void init() {
		pgDT=new JdbcTemplate(pgDS);
	}
	
	public void backup(Man man, long id) {
		if (id==0) return;
		if (checkID(id)) return;
		pgDT.execute("insert into public.person (id,fio,insnmb,prnsex,prnbrd) values ("+id+",'"
		+(man.getFamily()+" "+man.getName()+" "+man.getOtch())+"','"+man.getSNILS()+"','"+man.getSex()
		+"',Date('"+Utils.getFormattedDate4sql2(man.getBirthDayDate())+"'))");
		saveStaj(id,man.getStaj(),1);
		saveStaj(id,man.getStajKonv(),2);
		savePlatej(id,man.getPlateg20002001());
		saveVsnosy(id,man.getVsnosy());
	}
	
	public Man restore(long id) {
		if (id==0) return null;
		if (!checkID(id)) return null;
		Man man = pgDT.queryForObject("select * from public.person where id="+id,mnRowMapper);
		loadStaj(id,man,1);
		loadStaj(id,man,2);
		loadPlatej(id,man);
		loadVsnosy(id,man);
		return man;
	}
	
	private boolean checkID(long id) {
		int count=pgDT.queryForObject("select count(*) from public.person where id=?",Integer.class,id);
		return count>0;
	}
	
	
//	id bigint NOT NULL, -- Номер запроса справки
//	vid smallint NOT NULL, -- Тип источника
//	dstart date NOT NULL, -- Дата с
//	dend date NOT NULL, -- Дата по
//	regn character varying(15), -- Рег.номер страхователя
//	predpr_name character varying(100), -- Наименование страхователя
//	vid_deyat character varying(40), -- Вид деятельности
//	cggext character varying(30), -- Территориальные условия
//	cspext character varying(30), -- Выслуга лет
//	ctpext character varying(30), -- Исчесляемый стаж
//	cwcext character varying(30), -- Особые условия
//	dopctpext character varying(60), -- Доп.параметры к исчесляемому стажу
//	dopcspext character varying(60) -- Доп. параметры к выслуги лет
//  сохранение стажа (vid 1-данные работодателя, 2-конвертация)
	private void saveStaj(long id,List<Staj> stl, int vid) {
		if (stl==null || stl.isEmpty()) return;
		for(Staj st:stl) {
//			pgDT.update("insert into public.stag (id,vid,dstart,dend,regn,predpr_name,vid_deyat,cggext,cspext,ctpext,cwcext,dopctpext,dopcspext) values("+
//			id+","+
//			vid+",DATE('"+
//			Utils.getFormattedDate4sql2(st.getStartDate())+"'),DATE('"+
//			Utils.getFormattedDate4sql2(st.getEndDate())+"'),'"+
//			st.getRegNumb()+"','"+
//			st.getPredprName()+"','"+
//			st.getVidDeyat()+"','"+
//			st.getCggext()+"','"+
//			st.getCspext()+"','"+
//			st.getCtpext()+"','"+
//			st.getCwcext()+"','"+
//			st.getDopctpext()+"','"+
//			st.getDopcspext()+"')");
			pgDT.update("insert into public.stag (id,vid,dstart,dend,regn,predpr_name,vid_deyat,cggext,cspext,ctpext,cwcext,dopctpext,dopcspext) values(?,?,?,?,?,?,?,?,?,?,?,?,?)",
					id,vid,st.getStartDate(),st.getEndDate(),
					//Utils.getFormattedDate4sql2(st.getStartDate()),
					//Utils.getFormattedDate4sql2(st.getEndDate()),
					st.getRegNumb(),
					st.getPredprName(),
					st.getVidDeyat(),
					st.getCggext(),
					st.getCspext(),st.getCtpext(),st.getCwcext(),
					st.getDopctpext(),st.getDopcspext());

		}
	}
	
	
//	id bigint NOT NULL, -- Номер запроса справки
//	datestart date NOT NULL, -- Дата с
//	dateend date NOT NULL, -- Дата по
//	raion integer, -- Район
//	region integer, -- Регион
//	summa real -- Сумма
//	зарплата за 2000-2002 гг. сохранение
	private void savePlatej(long id,List<Platej> pll) {
		if (pll==null || pll.isEmpty()) return;
		for(Platej pl:pll) {
			pgDT.update("insert into public.payment (id,datestart,dateend,raion,region,summa)"
						+ " values("+
						id+",DATE('"+
						Utils.getFormattedDate4sql2(pl.getdStart())+"'), DATE('"+
						Utils.getFormattedDate4sql2(pl.getdEnd())+"'),"+
						pl.getRaion()+","+
						pl.getRegion()+","+
						pl.getSumma()+")");
		}
	}
	
//	  id bigint NOT NULL, -- Номер запроса справки
//	  dptcod integer NOT NULL, -- Код района
//	  dcinmb bigint NOT NULL, -- Входящий номер ПТК СПУ
//	  year integer, -- Год
//	  ctmcod character varying(10), -- Период
//	  asr real, -- Сумма
//	  cprcod integer, -- Код ЗЛ
//	  regnum character varying(14) -- Номер
//	  сохранение взносов
	private void saveVsnosy(long id,List<Vsnos> vsl) {
		if (vsl==null || vsl.isEmpty()) return;
	for(Vsnos vs:vsl) {
		pgDT.update("insert into public.vznos (id,dptcod,dcinmb,year,ctmcod,asr,cprcod,regnum,cprext) values("+id+","+
				    vs.getDptcod()+","+
				    vs.getDcinmb()+","+
				    vs.getYear()+",'"+
				    vs.getCtmcod()+"',"+
				    vs.getAsr()+","+
				    vs.getCprcod()+",'"+
				    vs.getRegNumb()+"','"+
				    vs.getCprext()+"')");
		}
	}
	
		//загрузка стажа (vid 1-данные работодателя, 2-конвертация)
		private void loadStaj(long id,Man man, int vid) {
			if (vid==2) man.setStajKonv(pgDT.query("select * from public.stag where id="+id+" and vid="+vid,stRowMapper ));
			else man.setStaj(pgDT.query("select * from public.stag where id="+id+" and vid="+vid,stRowMapper ));
		}
		
		//зарплата за 2000-2002 гг. загрузка
		private void loadPlatej(long id, Man man) {
			man.setPlateg20002001(pgDT.query("select * from public.payment where id="+id,plRowMapper ));
		}
		
		//загрузка взносов
		private void loadVsnosy(long id, Man man) {
			man.setVsnosy(pgDT.query("select * from public.vznos where id="+id,vsRowMapper ));
		}
		
		private RowMapper<Staj> stRowMapper = new RowMapper<Staj>() {
			public Staj mapRow(ResultSet rs, int rowNum) throws SQLException {
				Staj staj = new Staj();
				staj.setRegNumb(rs.getString("regn"));
				staj.setPredprName(rs.getString("predpr_name"));
				staj.setStartDate(rs.getDate("dstart"));
				staj.setEndDate(rs.getDate("dend"));
				staj.setVidDeyat(rs.getString("vid_deyat"));
				staj.setCggext(rs.getString("cggext"));
				staj.setCspext(rs.getString("cspext"));
				staj.setCtpext(rs.getString("ctpext"));
				staj.setCwcext(rs.getString("cwcext"));
				staj.setDopctpext(rs.getString("dopctpext"));
				staj.setDopcspext(rs.getString("dopcspext"));
				return staj;
			}
		};
	
		private RowMapper<Vsnos> vsRowMapper = new RowMapper<Vsnos>() {
			public Vsnos mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (rs.getString("asr")==null || rs.getString("asr").isEmpty()) return null;
				Vsnos vsnos = new Vsnos();
				vsnos.setDptcod(rs.getInt("dptcod"));
				vsnos.setDcinmb(rs.getLong("dcinmb"));
				vsnos.setCtmcod(rs.getString("ctmcod"));
				vsnos.setRegNumb(rs.getString("regnum"));
				vsnos.setAsr(Float.parseFloat(rs.getString("asr").replace(",",".")));
				vsnos.setCprext(rs.getString("cprext"));
				return vsnos;
			}
		};

	    private RowMapper<Platej> plRowMapper = new RowMapper<Platej>() {
			public Platej mapRow(ResultSet rs, int rowNum) throws SQLException {
				Platej platej = new Platej();
				platej.setdStart(rs.getDate("datestart"));
				platej.setdEnd(rs.getDate("dateend"));
				platej.setRaion(rs.getInt("raion"));
				platej.setRaion(rs.getInt("region"));
				platej.setSumma(rs.getFloat("summa"));
				return platej;
			}
		};
		
		private RowMapper<Man> mnRowMapper = new RowMapper<Man>() {
			public Man mapRow(ResultSet rs, int rowNum) throws SQLException {
				Man m = new Man();
				m.setBirthDayDate(rs.getDate("prnbrd"));
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
	}
