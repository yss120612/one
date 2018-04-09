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

import com.yss1.one.models.LgotaDescription;
import com.yss1.one.models.LgotaUnion;
import com.yss1.one.models.Staj;

//Список что дает льгота
@Repository
public class LgotaDescrDao {
	@Autowired
	private DataSource pgDS;
	
	private List<LgotaDescription> lgotes;
	
	private void fillLgotes()
	{
		JdbcTemplate pgDT=new JdbcTemplate(pgDS);
		Integer count;
		lgotes=pgDT.query("select * from lgota", lgotaRowMapper);
		if (lgotes!=null) for (LgotaDescription lgd: lgotes) {
			count=pgDT.queryForObject("select count(*) from union_lgota where kod1=?",Integer.class,lgd.getName());
			if (count>0) {
				lgd.setForSumm(pgDT.query("select * from union_lgota where kod1=?", new Object [] {lgd.getName()}, lgotaUnionRowMapper));
			}
		}
		
//		String s;
//		for (LgotaDescription ld: lgotes) {
//			s=ld.getName()+"union with:";
//			if (ld.getForSumm()!=null) for (LgotaUnion lu : ld.getForSumm()) {
//				s+=lu.getCode()+", ";
//			}
//			System.out.println(s);
//		}
		
	}
	
	public Set<String> checkLgotes(List<Staj> stl){
		if (lgotes==null) fillLgotes();
		Set<String> res=new HashSet<>();
		for (Staj st:stl) {
			if (st.getCggext().isEmpty() && st.getCwcext().isEmpty() && st.getCspext().isEmpty()) continue;
			for (LgotaDescription lgt:lgotes) {
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
	
	private RowMapper<LgotaDescription> lgotaRowMapper = new RowMapper<LgotaDescription>() {
		public LgotaDescription mapRow(ResultSet rs, int rowNum) throws SQLException {
			LgotaDescription lg=new LgotaDescription();
			lg.setName(rs.getString("lgota"));
			lg.setField(rs.getString("field"));
			lg.setHalf(rs.getFloat("half"));
			lg.setMan_os(rs.getFloat("man_os"));
			lg.setWoman_os(rs.getFloat("woman_os"));
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
			lg.setFullName(rs.getString("comment"));
			lg.setNorthPlus(rs.getInt("sevplus")>0.01f);
			return lg;
		}
	};

	private RowMapper<LgotaUnion> lgotaUnionRowMapper = new RowMapper<LgotaUnion>() {
		public LgotaUnion mapRow(ResultSet rs, int rowNum) throws SQLException {
			LgotaUnion lu=new LgotaUnion();
			lu.setCode(rs.getString("kod2"));
			lu.setKoeff(rs.getFloat("koef"));
			lu.setUsl_man(rs.getFloat("usl_m"));
			lu.setUsl_woman(rs.getFloat("usl_w"));
			lu.setJoinCode(rs.getString("main"));
			return lu;
		}
	};
	
	public LgotaDescription getLgota(String name) {
		if (lgotes==null) fillLgotes();	
		for (LgotaDescription lgt:lgotes) {
			if (lgt.getName().equals(name)) return lgt;
		}
		return null;
	}
}
