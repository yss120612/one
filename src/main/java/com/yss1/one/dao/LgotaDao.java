package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yss1.one.models.Lgota;
import com.yss1.one.models.Staj;



@Repository
public class LgotaDao {
	@Autowired
	private DataSource pgDS;
	
	private List<Lgota> lgotes;
	
	private void fillLgotes()
	{
		JdbcTemplate pgDT=new JdbcTemplate(pgDS);
		lgotes=pgDT.query("select * from lgota", lgotaRowMapper);
	}
	
	public Set<String> checkLgotes(List<Staj> stl){
		if (lgotes==null) fillLgotes();
		Set<String> res=new HashSet<>();
		for (Staj st:stl) {
			if (st.getCggext().isEmpty() && st.getCwcext().isEmpty() && st.getCspext().isEmpty()) continue;
			for (Lgota lgt:lgotes) {
				if (lgt.getField().equals("cggext")) {
					if (st.getCggext().equals(lgt.getName())) {
						if (!res.contains(lgt.getName())) res.add(lgt.getName());
					}
				}else if (lgt.getField().equals("cwcext")) {
					if (st.getCwcext().equals(lgt.getName())) {
						if (!res.contains(lgt.getName())) res.add(lgt.getName());
					}
				}else if (lgt.getField().equals("cspext")) {
					if (st.getCspext().equals(lgt.getName())) {
						if (!res.contains(lgt.getName())) res.add(lgt.getName());
					}
				}
			}
		}
		return res;
	}
	
	private RowMapper<Lgota> lgotaRowMapper = new RowMapper<Lgota>() {
		public Lgota mapRow(ResultSet rs, int rowNum) throws SQLException {
			Lgota lg=new Lgota();
			lg.setName(rs.getString("lgota"));
			lg.setField(rs.getString("field"));
			lg.setHalf(rs.getFloat("half"));
			lg.setMan_os(rs.getFloat("man_os"));
			lg.setWoman_ds(rs.getFloat("woman_os"));
			lg.setMan_pens(rs.getFloat("man_pens"));
			lg.setWoman_pens(rs.getFloat("woman_pens"));
			lg.setMan_ss(rs.getFloat("man_ss"));
			lg.setWoman_ss(rs.getFloat("woman_ss"));
			lg.setMan_d(rs.getFloat("man_d"));
			lg.setWoman_d(rs.getFloat("woman_d"));
			lg.setMan_ds(rs.getFloat("man_ds"));
			lg.setWoman_ds(rs.getFloat("woman_ds"));
			lg.setMan_ss(rs.getFloat("man_ss"));
			lg.setWoman_ss(rs.getFloat("woman_ss"));
			lg.setSever(rs.getFloat("sever"));
			lg.setLepro(rs.getFloat("lepro"));
			return lg;
		}
	};

	public Lgota getLgota(String name) {
		if (lgotes==null) fillLgotes();	
		for (Lgota lgt:lgotes) {
			if (lgt.getName().equals(name)) return lgt;
		}
		return null;
	}
}
