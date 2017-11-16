package com.yss1.one.util;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	public static String getFormattedDate(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(d);
	}
	
	public static Integer getFormattedDate4period(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy0MM0dd");
		return Integer.parseInt(sdf.format(d));
	}
	
	
	public static Period calcPeriod(Date ds,Date df)
	{
		int diff=getFormattedDate4period(df)-getFormattedDate4period(ds);
		int month=diff%100;
		return new Period(0,0,0);
		
	}
	
	
	public static String getFormattedDate4sql(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(d);
	}
	
	
	public static String bytes2HexStr(byte[] ba) {
		StringBuilder sb=new StringBuilder();
		for (byte b:ba)
		{
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
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
