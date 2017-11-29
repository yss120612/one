package com.yss1.one.models;

import java.util.Date;

public class PerfMeterUnit {
	private Date start;
	private Date finish;
	private String comment;

	public PerfMeterUnit() {
		start = new Date();
		finish = null;
		comment = "";
	}

	public void stop(String comment) {
		this.comment = comment;
		finish = new Date();
	}

	public boolean isFinished() {
		return finish!=null;
	}
	
	public String getInfo() {
		if (!isFinished()) return "";
		float duration = (finish.getTime() - start.getTime()) / 1000f;
		return String.format("%.2f:%s",duration,comment) ;
	}

}
