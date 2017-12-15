package com.yss1.one;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	DataSource pgDS;

	@Autowired
	MainDao mainDao;

//	@PostConstruct
//	public void init() {
//		pgDS = (DataSource) ctx.getBean("postgressDS");
//	}

//	@Scheduled(fixedRate = 30000)
	private void run() {
		try {
			HashMap<Integer, String> mans = new HashMap<>();
			Connection conn = pgDS.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select id,Vc_ins from  public.spravka where ts_a is null";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				mans.put(rs.getInt("id"), rs.getString("Vc_ins"));
			}
			rs.close();
			stmt.close();

			for (Map.Entry<Integer, String> pair : mans.entrySet()) {
				mainDao.calculate(pair.getValue(), pair.getKey());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
