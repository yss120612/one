package com.yss1.one.calc;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.yss1.one.models.Man;
import com.yss1.one.models.Staj;
import com.yss1.one.util.Utils;



public class AS400Data {
	
	 private Man man;
	 private String fieldCsp;
	 private String fieldCtp;
	 private int dateSpos;
	 private int dateFpos;
	 public DataSource dataSource2(){
		SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
       dataSource.setDriverClassName("com.ibm.as400.access.AS400JDBCDriver");
       dataSource.setUrl("jdbc:as400://10.48.0.14");
       dataSource.setUsername("PD485100");
       dataSource.setPassword("PD495100");
       return dataSource;
   }
	
	public String load(String snils) throws SQLException
	{
		snils=Utils.rawSNILS(snils);
		
		if (snils.isEmpty())
		{
			return "Пустой или не правильный снилс!";
		}
		
		SingleConnectionDataSource sds = (SingleConnectionDataSource )dataSource2();
		JdbcTemplate jt=new JdbcTemplate(sds);
		man=null;
		
		try
		{
			
		jt.update("call OPFRSOFT.PFRBAT0201('R002000018/"+snils+"/')");
		man=jt.queryForObject("select * FROM QTEMP.R002000018",manRowMapper);
		if (man==null) {
			sds.getConnection().close();
			return "Снилс "+snils+" не найден!";
		}
		
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
			System.out.println("HEREEEE");
		}
		
		
		
		}
		catch(Exception ex)
		{
			sds.getConnection().close();
			return "Ошибка запроса к AS400!"+"\n"+ex.getMessage();
		}
		res=man.getFamily()+" "+man.getName()+" "+man.getOtch()+" "+man.getFormattedBirthday()+" "+man.getSNILS()+"<br>";
		man.calcStaj();
		res=res+man.getPeriod().toString()+"<br>";
		res+=man.res;
		sds.getConnection().close();
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
	
	private RowMapper<Man> manRowMapper = new RowMapper<Man>() {
		public Man mapRow(ResultSet rs, int rowNum) throws SQLException {
			Man m = new Man();
			m.setBirthDay(Utils.makeDate(rs.getString("prnbrd"),"\\."));
			m.setFio(rs.getString("fio"));
			m.setSNILS(rs.getString("insnmb"));
			return m;
		}
	};

	private String res;
	public String getRes() {
		// TODO Auto-generated method stub
		return res;
	}
	
	
	
	
	
	
	
}
