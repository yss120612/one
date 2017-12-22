package com.yss1.one;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.yss1.one.dao.MainDao;
import com.yss1.one.util.Twix;

@Service
@EnableScheduling
public class SheduleBaseScan {
	@Value("${scan_timeout}")
	private int timeout;
	//private int counter = 0;

	//@Autowired
	//ApplicationContext ctx;
	@Autowired
	//DataSource pgDS;
	private JdbcTemplate pgDT;

	@Autowired
	MainDao mainDao;

//	@PostConstruct
//	public void init() {
//		pgDS = (DataSource) ctx.getBean("postgressDS");
//	}

	@Scheduled(fixedRate = 30000)
	private void run() {
		try {
			
			String sql = "select id,vc_ins from  public.spravka where ts_a is null";
			List<Twix<Integer,String>> list = pgDT.query(sql, queryRowMapper);
			for (Twix<Integer,String> pair : list) {
				//System.out.println("Val="+pair.getVal()+" Key="+pair.getKey());
				mainDao.calculate(pair.getVal(), pair.getKey());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private RowMapper<Twix<Integer,String>> queryRowMapper = new RowMapper<Twix<Integer,String>>() {
		public Twix<Integer,String> mapRow(ResultSet rs, int rowNum) throws SQLException {
			Twix<Integer,String> mm = new Twix<Integer,String>(rs.getInt("id"),rs.getString("vc_ins"));
			return mm;
		}
	};
	
	
}
