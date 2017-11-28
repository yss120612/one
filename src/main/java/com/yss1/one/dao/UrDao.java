package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yss1.one.util.Utils;

//Взаимодействие со справочником условия расчета
@Repository
public class UrDao {
	@Autowired
	private JdbcTemplate pgDT;

	//перемножаем все козффициенты ранее даты права на заданную суммы
	public float indexSumm(Date dp, float summ) {
		
		String sql = "select k_str from public.ur where datev<date(?) order by datev";
		List<Float> lf=pgDT.queryForList(sql, Float.class, Utils.getFormattedDate4sql2(dp));
		for (Float le: lf)
		{
			summ*=le;
		}
		return summ;
	}
}
