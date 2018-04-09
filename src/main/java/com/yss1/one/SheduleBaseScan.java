package com.yss1.one;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import com.yss1.one.dao.MainDao;

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
			
			String sql = "select id,vc_ins,Rk,Igd,otn_zp from  public.spravka where ts_a is null";
			List<ShHelper> list = pgDT.query(sql, queryRowMapper);
			for (ShHelper pair : list) {
				//System.out.println("Val="+pair.getVal()+" Key="+pair.getKey());
				mainDao.calculate(pair.getSnils(), pair.getId(), pair.getRk(),pair.getIjd(),pair.getOt());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private RowMapper<ShHelper> queryRowMapper = new RowMapper<ShHelper>() {
		public ShHelper mapRow(ResultSet rs, int rowNum) throws SQLException {
			ShHelper mm = new ShHelper(rs.getInt("id"),rs.getString("vc_ins"),rs.getObject("Rk")==null?0:rs.getInt("Rk"),rs.getObject("Igd")==null?0:rs.getInt("Igd"),rs.getObject("otn_zp")==null?0:rs.getFloat("otn_zp"));
			return mm;
		}
	};
	
	private class ShHelper{
		public float getOt() {
			return ot;
		}
		int id;
		String snils;
		int rk;
		int ijd;
		float ot;
		public ShHelper(int id, String snils, int rk, int ijd,float ot) {
			super();
			this.id = id;
			this.snils = snils;
			this.rk = rk;
			this.ijd = ijd;
			this.ot=ot;
		}
		public int getId() {
			return id;
		}
		public String getSnils() {
			return snils;
		}
		public int getRk() {
			return rk;
		}
		public int getIjd() {
			return ijd;
		}
		
	}
	
}
