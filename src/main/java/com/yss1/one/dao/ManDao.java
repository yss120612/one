package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
	private JdbcTemplate pgDT;
	
	public void save(Man man, long id) {
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
	
	public Man load(long id) {
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
	
	//сохранение стажа (vid 1-данные работодателя, 2-конвертация)
	private void saveStaj(long id,List<Staj> stl, int vid) {
		if (stl==null || stl.isEmpty()) return;
		for(Staj st:stl) {
			
		}
	}
	
	
//	  id bigint NOT NULL, -- Номер запроса справки
//	  datestart date NOT NULL, -- Дата с
//	  dateend date NOT NULL, -- Дата по
//	  raion integer, -- Район
//	  region integer, -- Регион
//	  summa real -- Сумма
	//зарплата за 2000-2002 гг. сохранение
	private void savePlatej(long id,List<Platej> pll) {
		if (pll==null || pll.isEmpty()) return;
		for(Platej pl:pll) {
			pgDT.execute("insert into public.payment (id,datestart,dateend,raion,region,summa)"
						+ " values()");
		}
	}
	
	//сохранение взносов
	private void saveVsnosy(long id,List<Vsnos> vsl) {
		if (vsl==null || vsl.isEmpty()) return;
	for(Vsnos vs:vsl) {
			
		}
	}
	
		//загрузка стажа (vid 1-данные работодателя, 2-конвертация)
		private void loadStaj(long id,Man man, int vid) {
			
		}
		
		//зарплата за 2000-2002 гг. загрузка
		private void loadPlatej(long id,Man man) {
			man.setPlateg20002001(pgDT.query("select * from public.payment where id="+id,plRowMapper ));
		}
		
		//загрузка взносов взносов
		private void loadVsnosy(long id,Man man) {
			
		}
		
		private RowMapper<Vsnos> vsRowMapper = new RowMapper<Vsnos>() {
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
				return m;
			}
		};
	
}
