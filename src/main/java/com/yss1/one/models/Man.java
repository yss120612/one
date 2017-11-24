package com.yss1.one.models;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.yss1.one.calc.RkCalculator;
import com.yss1.one.calc.RpRpkCalculator;
import com.yss1.one.calc.StajCalculator;
import com.yss1.one.util.ApplicationContextUtil;
import com.yss1.one.util.Period;
import com.yss1.one.util.Utils;


public class Man {
	//имя
	private String name;
	//фамилия
	private String family;
	//отчество
	private String otch;
	//пол
	private String sex;
	//дата рождения
	private Date birthDay;
	//СНИЛС
	private String SNILS;
	//периоды деятельности общий и на даты
	private Period periodAll, period1991, period2002, period2015;
	//Записи о стажах
	private List<Staj> staj;
	//Записи о стажах из конвертации
	private List<Staj> stajKonv;
	public String res;
	//коэффициент валоризации
	private float kVal;
	//коэффициент стажевый
	private float stajK;
	//коэффициент стажевый понижающий
	private float dopStajK;
	//коэффициент районный на 2001 год
	private float rk2001;
	//Записи о зарплате за 2000-2001 годы
	private List<Platej> plateg20002001;
	//коэффициент зарплатный за 2000-2001 годы
	private float kSal;
	
	//расчетная пенсия на 1 янв. 2002 года
	private float rP;
	
	//расчетный пенсионный капиталл
	private float rPK;
	
	
	RkCalculator rkCalc;
	StajCalculator stCalc;
	RpRpkCalculator rpRpkCalc;
	
	
	public Man() {

		rkCalc=(RkCalculator)ApplicationContextUtil.getApplicationContext().getBean(RkCalculator.class);
		stCalc=(StajCalculator)ApplicationContextUtil.getApplicationContext().getBean(StajCalculator.class);
		rpRpkCalc=(RpRpkCalculator)ApplicationContextUtil.getApplicationContext().getBean(RpRpkCalculator.class);
	}	
	
	 
	
	public List<Platej> getPlateg20002001() {
		return plateg20002001;
	}

	public void setPlateg20002001(List<Platej> plateg20002001) {
		this.plateg20002001 = plateg20002001;
	}

	

		
	
	public void calcStaj() {
		if (staj == null || staj.isEmpty()) {
			return;
		}

		sort();

		List<Staj> tmp = stCalc.orderStajRecords(staj,stajKonv);
		res = "";
		
		period1991 = stCalc.getStajBefore(tmp, Utils.makeDate(1990, 12, 31));
		period2002 = stCalc.getStajBefore(tmp, Utils.makeDate(2001, 12, 31));
		period2015 = stCalc.getStajBefore(tmp, Utils.makeDate(2014, 12, 31));
		periodAll  = stCalc.getStajAll(tmp);

		calcKVal();
		calcStajK();
		// rk2001 считается до SalK т.к. он его ограничивает 
		rk2001=rkCalc.calc(plateg20002001);
		calcSalK();
		rP=rpRpkCalc.CalcRp(stajK, kSal);
		rPK=rpRpkCalc.CalcRpk(dopStajK, rP,);
		
		
		
		res = "p1991=" + period1991 + " p2002=" + period2002 + " p2015=" + period2015+" KVal="+kVal+" StajK="+stajK+" ponStajK="+dopStajK+" RK="+rk2001+" Зар.К="+kSal+" RP="+rP+" RPK="+rPK+"<br>";
		for (Platej pl : plateg20002001) {
			res = res + pl.toString() + "<br>";
		}
		
		for (Staj st : tmp) {
			//periodAll.addPeriod(Utils.calcPeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()));
			res = res + st.toString() + "<br>";
		}
		
		

	}

	//расчет коэффициента валоризации
	public void calcKVal() {
		kVal = 0.1f;
		if (period1991 == null)
			return;
		kVal = (0.1f + 0.01f * period1991.getYears());
	}

	//расчет стажевого и понижающего стажевого козффициентов
	public void calcStajK() {
		stajK = 0.55f;
		dopStajK = 1f;
		int need = sex.toUpperCase().contains("М") ? 25 : 20;
		if (period2002.getYears() > need) {
			stajK += (period2002.getYears() - need) * 0.01f;
			if (stajK > 0.75f)
				stajK = 0.75f;
		} else {
			dopStajK = (period2002.getYears() * 12 + period2002.getMonths() + period2002.getDays() / 30f) / (need * 12f);
		}
	}
	
	//1494,50 =(1194,00*1324,00*1254,00*1257,00*1257,00*1257,00*1413,00*1411,00*1325,00*1528,00*1457,00*1584,00*1523,00*1523,00*1523,00*1724,00*1653,00*1635,00*1896,00*1550,00*1567,00*1671,00*1671,00*1671,00)/24
	//расчет зарплатного коэффициента
	public void calcSalK() {
		kSal=0f;
		int mon= period2002.getYears()*12+period2002.getMonths();
		if (mon>24) mon=24;
		float sal=0;
		if (plateg20002001==null || mon==0) return;
		for (Platej pl: plateg20002001) sal+=pl.getSumma();
		kSal=sal/mon/1494.5f;
		if (kSal>rk2001) kSal=rk2001;
	}
	
	public Period getPeriod() {
		return periodAll;
	}

	public String getName() {
		return name;
	}

	public void sort() {
		if (staj != null)
			Collections.sort(staj);
		if (stajKonv != null)
			Collections.sort(stajKonv);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getOtch() {
		return otch;
	}

	public void setOtch(String otch) {
		this.otch = otch;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getSNILS() {
		return SNILS;
	}

	public void setSNILS(String sNILS) {
		SNILS = sNILS;
	}

	public void setFio(String fio) {
		fio = fio.trim().replaceAll("\\s+", " ");
		String[] afio = fio.split(" ");
		if (afio.length > 1) {
			family = afio[0];
			name = afio[1];
		}
		if (afio.length > 2) {
			otch = afio[2];
		}
	}

	public List<Staj> getStaj() {
		return staj;
	}

	public List<Staj> getStajKonv() {
		return stajKonv;
	}

	public void setStaj(List<Staj> staj) {
		this.staj = staj;
	}

	public void setStajKonv(List<Staj> staj) {
		this.stajKonv = staj;
	}

	public String getFormattedBirthday() {
		return Utils.getFormattedDate(birthDay);
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
