package com.yss1.one.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Utils {
	public static boolean checkSNILS(String sn) {
		sn = sn.replaceAll("[\\-\\s]", "");
		if (sn.length() != 11)
			return false;
		return Integer.parseInt(sn.substring(9)) == calcSNILS(sn);
	}

	public static int calcSNILS(String sn) {
		sn = sn.replaceAll("[\\-\\s]", "").substring(0, 9);
		int otvet = 0;
		for (int i = 8; i >= 0; i--) {
			otvet = otvet + Integer.parseInt(sn.charAt(i) + "") * (9 - i);
		}
		if (otvet > 101) {
			otvet = otvet % 101;
		} else if (otvet > 99) {
			otvet = 0;
		}
		return otvet;
	}

	public static String rawSNILS(String sn) {
		String otv=sn.replaceAll("[\\-\\s]", "").trim();
		if (otv.length()<9 || !otv.matches("^\\d+$")) return "";
		return otv.substring(0, 9);
	}
	
	public static String getFormattedDate(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(d);
	}

	public static Integer getFormattedDate4period(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy0MM0dd");
		return Integer.parseInt(sdf.format(d));
	}

	public static Date makeDate(int y, int m, int d) {
		return new GregorianCalendar(y, m - 1, d).getTime();
	}

	
	
	public static Date makeDate(String s,String sep) {
		String [] as=s.trim().split(sep);
		if (as.length<3) return null;
		//System.out.println("s="+s+" year="+Integer.parseInt(as[2]));
		int year=Integer.parseInt(as[2]);
		if (year<1000)
		{
			if (year<30)
			{
				year+=2000;
			}
			else
			{
				year+=1900;
			}
		}
		return makeDate(year,Integer.parseInt(as[1]),Integer.parseInt(as[0]));
	}
	
	
	public static Period calcPeriod(Date ds, Date df, int ad) {
		String sdiff = String.format("%010d", getFormattedDate4period(df) - getFormattedDate4period(ds));
		int day = Integer.parseInt(sdiff.substring(sdiff.length() - 3, sdiff.length()));
		int month = Integer.parseInt(sdiff.substring(sdiff.length() - 6, sdiff.length() - 3));
		int year = Integer.parseInt(sdiff.substring(0, sdiff.length() - 6));
		if (day > 30)
			day = day - 970;
		if (month > 12)
			month = month - 988;
		day+=ad;
		year = year + (month + day / 30) / 12;
		month = (month + day / 30) % 12;
		day = day % 30;
		//System.out.println("2day=" + day + " month=" + month + " year=" + year);
		return new Period(year, month, day);
	}

	public static String getFormattedDate4sql(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(d);
	}

	public static String getFormattedDate4sql2(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(d);
	}
	
	public static String bytes2HexStr(byte[] ba) {
		StringBuilder sb = new StringBuilder();
		for (byte b : ba) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}

	public static void save2file(byte[] ba, String fileName) {
		FileOutputStream fw;
		try {
			fw = new FileOutputStream(fileName);
			fw.write(ba);
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean beforeOrEqual(Date d1, Date d2) {//d1 before or equal d2
		return !d1.after(d2);
	}

	public static boolean afterOrEqual(Date d1, Date d2) {//d1 after or equal d2
		return !d1.before(d2);
	}
	
	public static boolean between(Date d1, Date d2, Date d3) {//d1 after or equal d2
		return !d1.before(d2) && !d1.after(d3);
	}
	
	
	public static boolean intersect(Date s1,Date f1,Date s2,Date f2) {//пересекаются ли диапазоны дат s1..f1 и s2..f2
		return (afterOrEqual(s1, s2) && beforeOrEqual(s1, f2)) || (afterOrEqual(f1, s2) && beforeOrEqual(f1, f2))
				|| included(s1,f1,s2,f2) || included(s2,f2,s1,f1);
	}
	
	public static boolean included(Date s1,Date f1,Date s2,Date f2) {//включают ли диапазон дат s1..f1 диапазон s2..f2
		return beforeOrEqual(s1, s2) && afterOrEqual(f1, f2);
	}
	
	public static Date addDay(Date d, int days)
	{
		GregorianCalendar gc= new GregorianCalendar();
		gc.setTime(d);
		gc.add(GregorianCalendar.DAY_OF_MONTH,days);
		return gc.getTime();
	}
	
	
}
