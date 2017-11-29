package com.yss1.one.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.yss1.one.models.PerfMeterUnit;

@Component
// измеритель производительности
public class PerfMeter {
	private List<PerfMeterUnit> pfu;
	
	public PerfMeter() {
		pfu = new ArrayList<PerfMeterUnit>();
	}

	
	public void init() {
	pfu.clear();	
	}
	
	
	public void start() {
		pfu.add(new PerfMeterUnit());
	}

	public void measure(String comment) {
		if (pfu == null || pfu.isEmpty()) {
			return;
		}
		PerfMeterUnit pu = pfu.get(pfu.size() - 1);
		if (!pu.isFinished())
			pu.stop(comment);
	}

	public String getIntervals(String separator) {
		String result = "";
		for (PerfMeterUnit u : pfu) {
			if (!result.isEmpty())
				result += separator;
			if (u.isFinished()) {
				result += u.getInfo();
			}
		}
		return result;
	}
}