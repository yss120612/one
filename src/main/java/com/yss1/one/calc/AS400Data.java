package com.yss1.one.calc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;


import com.yss1.one.models.User;
import com.yss1.one.util.Utils;

public class AS400Data {
//	@Bean
//	@Primary
//	@ConfigurationProperties("app.datasource.as400")
//	private DataSourceProperties dataSourceProperties2() {
//	    return new DataSourceProperties();
//	}
//
//	@Bean(name = "as400")
//	@ConfigurationProperties("app.datasource.as400")
//	private DataSource dataSource2() {
//		return dataSourceProperties2().initializeDataSourceBuilder().build();
//	}
	
	 public DataSource dataSource2(){
		SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
       dataSource.setDriverClassName("com.ibm.as400.access.AS400JDBCDriver");
       dataSource.setUrl("jdbc:as400://10.48.0.14");
       dataSource.setUsername("PD485100");
       dataSource.setPassword("PD495100");
       return dataSource;
   }
	
	public boolean load(String snils) throws SQLException
	{
		snils=Utils.rawSNILS(snils);
		if (snils.isEmpty())
		{
			return false;
		}
		
		SingleConnectionDataSource sds = (SingleConnectionDataSource )dataSource2();
		
		JdbcTemplate jt=new JdbcTemplate(sds);
		
		jt.update("call OPFRSOFT.PFRBAT0201('R002000016/"+snils+"/')");
		//List<Staj> stajes=jt.query("select * FROM QTEMP.R002000016",stajRowMapper);
		
		res="START\n";
//		for (Staj s:stajes)	{
//			res=res+s+"/n";
//		}
		res=res+"FINISH";
		sds.getConnection().close();
		return true;
	}
	
//	private RowMapper<Staj> stajRowMapper = new RowMapper<Staj>() {
//		public Staj mapRow(ResultSet rs, int rowNum) throws SQLException {
//			Staj staj = new Staj();
//			staj.setStartDate(Utils.makeDate(rs.getString("pfwbeg"),"\\."));
//			staj.setEndDate(Utils.makeDate(rs.getString("pfwend"),"\\."));
//			staj.setCggext(rs.getString("cggext"));
//			staj.setCspext(rs.getString("cspext"));
//			staj.setCtpext(rs.getString("ctpext"));
//			staj.setCwcext(rs.getString("cwcext"));
//			staj.setDopctpext(rs.getString("dopctpext"));
//			staj.setDopcspext(rs.getString("dopcspext"));
//			return staj;
//		}
//	};

	private String res;
	public String getRes() {
		// TODO Auto-generated method stub
		return res;
	}
	
	
	
	
	
	
	
}
