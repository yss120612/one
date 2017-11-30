package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yss1.one.models.Vsnos;
import com.yss1.one.util.Utils;

@Repository
public class CategoryDao {
	@Autowired
	private JdbcTemplate pgDT;
	// меняем код взноса с буквенного на цифровой
	public void setCode(List<Vsnos> vl) {
		//String myd = Utils.getFormattedDate4sql2(Utils.makeDate(vsnos.getYear(), 1, 2));
		//String now = Utils.getFormattedDate4sql2(new Date());

//		Integer kod = null;
//		Integer count = pgDT.queryForObject("select count(*) from public.category where category='?' and Date('?') between dstart and COALESCE(dend,Date('?'))"
//				, Integer.class, vsnos.getCprext().trim(),myd,now);
//		if (count > 0) {
//		           	  kod = pgDT.queryForObject("select code from public.category where category='?' and Date('?') between dstart and COALESCE(dend,Date('?'))"
//					, Integer.class, vsnos.getCprext().trim(),myd,now);
//		}

		//List<Integer> lk=pgDT.query("select code from public.category where category='"+vsnos.getCprext().trim()+"' and Date('"+myd+"') between dstart and COALESCE(dend,Date('"+now+"'))",intRowMapper);
		List<CodeHelper> ch=pgDT.query("select code,category,dstart,dend from public.category where code>0",codeRowMapper);
		
		//System.out.println("Kode="+kod);
//		if (lk==null || lk.isEmpty()) {
//			vsnos.setCprcod(0);
//			return;
//		} else {
//			vsnos.setCprcod(lk.get(0));
//		}
		
		
		Date d1;
		for (Vsnos vs:vl) {
				d1=Utils.makeDate(vs.getYear(),1,2);
				for(CodeHelper h: ch) {
					if (vs.getCprext().equals(h.getCateg()) && Utils.between(d1, h.getDs(), h.getFd())) {
						vs.setCprcod(h.getCod());
						break;
					}
			}
	
		}
		
		
}

	//вспомогательный класс для кодов
	private class CodeHelper {
		private int cod;
		private String categ;
		private Date ds;
		private Date fd;
		
		public int getCod() {
			return cod;
		}

		public String getCateg() {
			return categ;
		}

		public Date getDs() {
			return ds;
		}

		public Date getFd() {
			return fd;
		}

		public CodeHelper(int cod, String categ, Date ds, Date fd) {
			this.cod = cod;
			this.categ = categ!=null?categ.trim():"";
			this.ds = ds;
			this.fd = fd==null?new Date():fd;
		}
		
		
		
		
}
	
	private RowMapper<CodeHelper> codeRowMapper = new RowMapper<CodeHelper>() {
		public CodeHelper mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			return new CodeHelper(rs.getInt("code"),rs.getString("category"),rs.getDate("dstart"),rs.getDate("dend"));
		}
	};

//	private RowMapper<Integer> intRowMapper = new RowMapper<Integer>() {
//		public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
//			return new Integer(rs.getInt(1));
//		}
//	};
	
	
	

}
