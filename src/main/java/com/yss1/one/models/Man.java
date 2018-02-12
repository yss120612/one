package com.yss1.one.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import com.yss1.one.calc.NpkCalculator;
import com.yss1.one.calc.PedCalculator;
import com.yss1.one.calc.RkCalculator;
import com.yss1.one.calc.UniversalCalculator;
import com.yss1.one.calc.StajCalculator;
import com.yss1.one.calc.VsnosCalculator;
import com.yss1.one.calc.CodeCalculator;
import com.yss1.one.calc.FinishCalculator;
import com.yss1.one.calc.LsCalculator;
import com.yss1.one.calc.MedCalculator;
import com.yss1.one.util.ApplicationContextUtil;
import com.yss1.one.util.PerfMeter;
import com.yss1.one.util.Period;
import com.yss1.one.util.Utils;

public class Man {
	// имя
	private String name;
	// фамилия
	private String family;
	// отчество
	private String otch;
	// пол
	private String sex;
	// дата рождения
	private GregorianCalendar birthDay;
	// СНИЛС
	private String SNILS;
	// периоды деятельности общий и на даты
	private Period periodAll, period1991, period2002, period2015;
	private Period periodNS;
	// Записи о стажах
	private List<Staj> staj;
	// Записи о стажах из конвертации
	private List<Staj> stajKonv;
	// записи о стаже рабочий вариант
	private List<Staj> rawStaj;
	// записи по предприятию
	private List<Deyatelnost> myDeyatelnost;

	// льготный стаж
	private List<LgStaj> myLgStaj;

	//количество иждевенцев
	private int ijdevency;
	
	public int getIjdevency() {
		return ijdevency;
	}

	public void setIjdevency(int ijdevency) {
		this.ijdevency = ijdevency;
	}

	public int getKoeffFix() {
		return koeffFix;
	}

	public void setKoeffFix(int koeffFix) {
		this.koeffFix = koeffFix;
	}

	//коэффициент для расчета фиксированной части	
	private int koeffFix;
	
	public String res;

	public List<Deyatelnost> getMyDeyatelnost() {
		return myDeyatelnost;
	}

	public void setMyDeyatelnost(List<Deyatelnost> myDeyatelnost) {
		this.myDeyatelnost = myDeyatelnost;
	}

	// коэффициент валоризации
	private float kVal;
	// коэффициент стажевый
	private float stajK;
	// коэффициент стажевый понижающий
	private float dopStajK;
	// коэффициент районный на 2001 год
	private float rk2001;

	public float getRk2001() {
		return rk2001;
	}

	//минимальное количество стажа и баллов на дату права для выхода на пенсию
	private int minYear;
	private float minBall;
	
	
	public int getMinYear() {
		return minYear;
	}

	public float getMinBall() {
		return minBall;
	}

	// стоимость пенсионного балла
	private float spk;

	public float getSpk() {
		return spk;
	}

	// Записи о зарплате за 2000-2001 годы
	private List<Platej> plateg20002001;
	// коэффициент зарплатный за 2000-2001 годы
	private float kSal;

	// взносы начисленнве
	private List<Vsnos> vsnosy;

	// расчетная пенсия на 1 янв. 2002 года
	private float rP;

	// расчетный пенсионный капиталл
	private float rPK;

	// дата права
	private GregorianCalendar datePrav;

	// льготный выход на пенсию
	private int lgota;

	// начальный пенсионный капиталл
	private float nPK;

	// учтенные взносы за 2002-2014 годы
	private float vsnos0215;

	// индивидуальный пенсионный коэффициент на 1.01.2015г.
	private float ipk15;

	// индивидуальный пенсионный коэффициент c 1.01.2015г.
	private float ipkGr15;

	// индивидуальный пенсионный коэффициент.
	private float ipk;

	// расчитанная пенсия
	float pensiya;

	// период дожития
	int dojytiye;

	// расчитанная фиксированная выплата
	float fix;

	// в 2000-2001 году зп максимальна?
	boolean isMax20002001;

	// в 2000-2001 году средняя зп в месяц
	float sal20002001;

	private Set<String> lgotes;

	// калькуляторы
	RkCalculator rkCalc;
	StajCalculator stCalc;
	UniversalCalculator uniCalc;
	NpkCalculator npkCalc;
	CodeCalculator codeCalc;
	VsnosCalculator vsnosCalc;
	FinishCalculator finCalc;
	MedCalculator medCalc;
	PedCalculator pedCalc;
	LsCalculator lsCalc;
	PerfMeter meter;

	public Man() {
		rkCalc = (RkCalculator) ApplicationContextUtil.getApplicationContext().getBean(RkCalculator.class);
		stCalc = (StajCalculator) ApplicationContextUtil.getApplicationContext().getBean(StajCalculator.class);
		uniCalc = (UniversalCalculator) ApplicationContextUtil.getApplicationContext()
				.getBean(UniversalCalculator.class);
		npkCalc = (NpkCalculator) ApplicationContextUtil.getApplicationContext().getBean(NpkCalculator.class);
		codeCalc = (CodeCalculator) ApplicationContextUtil.getApplicationContext().getBean(CodeCalculator.class);
		vsnosCalc = (VsnosCalculator) ApplicationContextUtil.getApplicationContext().getBean(VsnosCalculator.class);
		medCalc = (MedCalculator) ApplicationContextUtil.getApplicationContext().getBean(MedCalculator.class);
		pedCalc = (PedCalculator) ApplicationContextUtil.getApplicationContext().getBean(PedCalculator.class);
		finCalc = (FinishCalculator) ApplicationContextUtil.getApplicationContext().getBean(FinishCalculator.class);
		lsCalc = (LsCalculator) ApplicationContextUtil.getApplicationContext().getBean(LsCalculator.class);
		meter = (PerfMeter) ApplicationContextUtil.getApplicationContext().getBean(PerfMeter.class);
		ijdevency=0;
		koeffFix=0;
	}

	public void calcPens() {
		if (staj == null || staj.isEmpty()) {
			return;
		}

		// сортируем по дате начала стажа
		sortStaj();

		// сохраняем стаж, получаем список льгот
		rawStaj = stCalc.copyAndPrepareStajes(staj, stajKonv);

		// расчитываем общий стаж
		List<Staj> tmp = stCalc.orderStajRecords(staj, stajKonv);
		period1991 = stCalc.getStajBefore(tmp, Utils.makeDate(1990, 12, 31));
		period2002 = stCalc.getStajBefore(tmp, Utils.makeDate(2001, 12, 31));
		period2015 = stCalc.getStajBefore(tmp, Utils.makeDate(2014, 12, 31));
		periodAll = stCalc.getStajAll(tmp);
		periodNS = lsCalc.calcNS(rawStaj);

		myDeyatelnost = stCalc.getPredprStaj(rawStaj, vsnosy);
		myDeyatelnost.removeIf(x -> x == null);

		myLgStaj = new ArrayList<>();
		// List<String> med=new ArrayList<>();
		LgStaj lst;
		int maxMonth = 0;
		Period lper;
		lgotes = stCalc.getLgotes();
		boolean pedStaj = false;
		boolean north = false;

		for (String s : lgotes) {
			if (pedStaj && (s.equals("27-ПД") || s.equals("27-ПДРК")))
				continue;
			rawStaj = stCalc.copyStajes(staj, stajKonv);
			// med.clear();
			if (s.equals("27-СМХР") || s.equals("27-ГДХР") || s.equals("27-ГД") || s.equals("27-СМ")) {
				lper = medCalc.getMedStaj(rawStaj, s);
				lst = new LgStaj(s, lper);
			} else if (s.equals("27-ПД") || s.equals("27-ПДРК")) {
				pedStaj = true;
				s = "27-ПД";
				lper = pedCalc.getPedStaj(rawStaj);
				lst = new LgStaj(s, lper);
			} else {// остальные
				if (s.equals("МКС") || s.equals("РКС"))
					north = true;
				lper = lsCalc.calcLS2(rawStaj, s, !sex.toUpperCase().contains("Ж"));
				lst = new LgStaj(s, lper);
				lst.setAbsPeriod(lsCalc.calcAbsLS(rawStaj, s));

			}

			myLgStaj.add(lst);
			res = res + lst.toString() + "<br>";
		}

		

		//вычисляем добавки к северу
		Period forNorth = new Period(0, 0, 0);
		for (LgStaj lgs : myLgStaj) {
			if (north && lsCalc.isNorthPlus(lgs.getName())) {
				rawStaj = stCalc.copyStajes(staj, stajKonv);
				forNorth.addPeriod(lsCalc.getForNorth(rawStaj, lgs.getName()));
			}
		}

		
		for (LgStaj lgs : myLgStaj) {
			if (north && (lgs.getName().equals("МКС") || lgs.getName().equals("РКС"))) {
				lgs.getPeriod().addPeriod(forNorth);
				
				//проверяем правильно ли ввели коэффициент для фиксированной части, если нет - ставим принудительно
				if (getSex().toUpperCase().contains("Ж")) {
					if (lgs.getName().equals("РКС") && lgs.getPeriod().getYears() >= 15 && periodAll.getYears() >= 20) {
						koeffFix = 2;
					}
					if (lgs.getName().equals("МКС") && lgs.getPeriod().getYears() >= 15 && periodAll.getYears() >= 20
							&& koeffFix < 2) {
						koeffFix = 1;
					}

				} else {
					if (lgs.getName().equals("РКС") && lgs.getPeriod().getYears() >= 15 && periodAll.getYears() >= 25) {
						koeffFix = 2;
					}
					if (lgs.getName().equals("МКС") && lgs.getPeriod().getYears() >= 15 && periodAll.getYears() >= 25
							&& koeffFix < 2) {
						koeffFix = 1;
					}
				}
			}

			lgs.setMonth(lsCalc.calcLgotMonth(lgs.getPeriod(), lgs.getName(), periodAll.getYears(),
					!getSex().contains("Ж")));
			maxMonth = Math.max(maxMonth, lgs.getMonth());
		}

		if (maxMonth > 0) {
			datePrav.add(GregorianCalendar.MONTH, -maxMonth);
			lgota = 1;
		}

		calcKVal();

		calcStajK();

		// rk2001 считается до SalK т.к. он его ограничивает
		rk2001 = rkCalc.calc(plateg20002001);

		// расчет зарплатного коэффициента
		calcSalK();

		rP = uniCalc.rpCalc(stajK, kSal);

		rPK = uniCalc.rpkCalc(dopStajK, rP, datePrav.get(GregorianCalendar.YEAR), lgota != 0);

		nPK = npkCalc.calc(rPK, kVal, getDatePravDate());

		codeCalc.calc(vsnosy);

		vsnos0215 = vsnosCalc.calc(vsnosy, birthDay, datePrav, meter);

		dojytiye = uniCalc.getDojytie(datePrav.get(GregorianCalendar.YEAR), lgota != 0);

		ipk15 = uniCalc.npk15Calc(nPK, vsnos0215, datePrav.get(GregorianCalendar.YEAR), lgota != 0);

		ipkGr15 = finCalc.calcIPK(vsnosy, datePrav.getTime());

		ipk = ipk15 + ipkGr15;

		spk = finCalc.getSpk(datePrav.getTime());

		minBall=finCalc.getMinBall(datePrav.get(GregorianCalendar.YEAR));
		
		minYear=finCalc.getMinYear(datePrav.get(GregorianCalendar.YEAR));
		
		pensiya = ipk * spk;

		
		
		fix = finCalc.calcFix(datePrav.getTime(),koeffFix,ijdevency);

		
		
		
		res = res +
		// "MKS="+mksPer+" Staj="+sPer+
		// " МЕД СМХР="+medSMHRPer+" МЕД ГДХР="+medGDHRPer+"МЕД СМ="+medSMPer+"МЕД
		// ГД="+medGDPer+" МЕД СЕЛО="+medSeloPer+" PedPer="+pedPer+
				"<br>p1991=" + period1991 + " p2002=" + period2002 + " p2015=" + period2015 + " KVal=" + kVal
				+ " StajK=" + stajK + " ponStajK=" + dopStajK + " RK=" + rk2001 + " Зар.К=" + kSal + " RP=" + rP
				+ " RPK=" + rPK + " pravo=" + Utils.getFormattedDate(datePrav.getTime()) + " NPK=" + nPK
				+ " vsnosy02-15=" + vsnos0215 + " ipk15=" + ipk15 + " ipk=" + ipk + "<br>" + " Pensya=" + pensiya
				+ " Fix vipl=" + fix + "<br>" + meter.getIntervals("<br>") + "<br>";

		// System.out.println(res);
		// for (Platej pl : plateg20002001) {
		// res = res + pl.toString() + "<br>";
		// }

		// for (Vsnos vs : vsnosy) {
		// res = res + vs.toString() + "<br>";
		// }

		// rawStaj = stCalc.copyStajes(staj,stajKonv);
		// for (Deyatelnost de : myDeyatelnost) {
		// for (Staj st : rawStaj) {
		// periodAll.addPeriod(Utils.calcPeriod(st.getStartDate(), st.getEndDate(),
		// st.getAddDay()));
		// res = res + de.toString() + "<br>";
		// }
	}

	public float getVsnos0215() {
		return vsnos0215;
	}

	public float getnPK() {
		return nPK;
	}

	public float getrPK() {
		return rPK;
	}

	public String getBall2002() {
		return String.format("%,.2f", dojytiye == 0 ? 0 : nPK / dojytiye / 64.1f);
	}

	public String getBall2014() {
		return String.format("%,.2f", dojytiye == 0 ? 0 : vsnos0215 / dojytiye / 64.1f);
	}

	public String getBall2015() {
		return String.format("%,.2f", ipkGr15);
	}

	public String getDojSt() {
		return String.format("%d", dojytiye);
	}

	public float getDoj() {
		return dojytiye;
	}

	public String getIPK() {
		return String.format("%,.2f", ipk);
	}

	public Set<String> getLgotes() {
		return lgotes;
	}

	public List<LgStaj> getMyLgStaj() {
		return myLgStaj;
	}

	// расчет коэффициента валоризации
	public void calcKVal() {
		kVal = 0.1f;
		if (period1991 == null)
			return;
		kVal = (0.1f + 0.01f * period1991.getYears());
	}

	// расчет стажевого и понижающего стажевого козффициентов
	public void calcStajK() {

		stajK = 0.55f;
		dopStajK = 1f;
		float need = sex.toUpperCase().contains("М") ? 25.0f : 20.0f;
		if (period2002.getYears() >= need) {
			stajK += (period2002.getYears() - need) * 0.01f;
			if (stajK > 0.75f)
				stajK = 0.75f;
		} else {
			dopStajK = (period2002.getYears() * 12.0f + period2002.getMonths() + period2002.getDays() / 30.0f)
					/ (need * 12.0f);
			// System.out.println("chis="+(period2002.getYears() * 12.0f +
			// period2002.getMonths() + period2002.getDays() / 30.0f)+" snam="+(need *
			// 12.0f));
		}
	}

	// 1494,50
	// =(1194,00*1324,00*1254,00*1257,00*1257,00*1257,00*1413,00*1411,00*1325,00*1528,00*1457,00*1584,00*1523,00*1523,00*1523,00*1724,00*1653,00*1635,00*1896,00*1550,00*1567,00*1671,00*1671,00*1671,00)/24
	// расчет зарплатного коэффициента
	public void calcSalK() {
		kSal = 0f;
		int mon = period2002.getYears() * 12 + period2002.getMonths();
		if (mon > 24)
			mon = 24;
		sal20002001 = 0;
		if (plateg20002001 == null || mon == 0)
			return;
		for (Platej pl : plateg20002001) {
			// System.out.println("platej="+pl.getSumma());
			sal20002001 += pl.getSumma();
		}
		sal20002001 = sal20002001 / mon;
		kSal = sal20002001 / 1494.5f;
		if (kSal >= rk2001) {
			kSal = rk2001;
			isMax20002001 = true;
		} else {
			isMax20002001 = false;
		}
	}

	public float getSal20012002() {
		return sal20002001;
	}

	public boolean isMax20002001() {
		return isMax20002001;
	}

	public Period getPeriod() {
		return periodAll;
	}

	public String getName() {
		return name;
	}

	public void sortStaj() {
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

	public Date getBirthDayDate() {
		return birthDay.getTime();
	}

	public String getBirthDayStr() {
		return Utils.getFormattedDate(birthDay.getTime());
	}

	public void setBirthDayDate(Date birthDay) {
		this.birthDay = new GregorianCalendar();
		this.birthDay.setTime(birthDay);
	}

	public GregorianCalendar getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(GregorianCalendar birthDay) {
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
		staj.removeIf(x -> x == null);
		this.staj = staj;
	}

	public void setStajKonv(List<Staj> staj) {
		this.stajKonv = staj;
	}

	public String getFormattedBirthday() {
		return Utils.getFormattedDate(birthDay.getTime());
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<Vsnos> getVsnosy() {
		return vsnosy;
	}

	public void setVsnosy(List<Vsnos> vsnosy) {
		vsnosy.removeIf(x -> x == null || x.getCprext() != null && x.getCprext().trim().equals("БЕЗР"));
		this.vsnosy = vsnosy;
	}

	public Period getPeriodAll() {
		if (periodAll != null)
			return periodAll;
		else
			return new Period(0, 0, 0);
	}

	public Period getPeriod1991() {
		if (period1991 != null)
			return period1991;
		else
			return new Period(0, 0, 0);
	}

	public Period getPeriod2002() {
		if (period2002 != null)
			return period2002;
		else
			return new Period(0, 0, 0);
	}

	public Period getPeriod2015() {
		if (period2015 != null)
			return period2015;
		else
			return new Period(0, 0, 0);
	}

	public float getkVal() {
		return kVal;
	}

	public float getkSal() {
		return kSal;
	}

	public float getIpk() {
		return ipk;
	}

	public float getPensiya() {
		return pensiya;
	}

	public float getFix() {
		return fix;
	}

	public float getSumm() {
		return pensiya + fix;
	}

	public String getPensiyaStr() {
		return String.format("%,.2f", pensiya);
	}

	public String getFixStr() {
		return String.format("%,.2f", fix);
	}

	public String getSummStr() {
		return String.format("%,.2f", pensiya + fix);
	}

	public String getRes() {
		// return res;
		return "";
	}

	public List<Platej> getPlateg20002001() {
		return plateg20002001;
	}

	public void setPlateg20002001(List<Platej> plateg20002001) {
		this.plateg20002001 = plateg20002001;
	}

	public Date getDatePravDate() {
		return datePrav.getTime();
	}

	public GregorianCalendar getDatePrav() {
		return datePrav;
	}

	public String getDatePravStr() {
		return Utils.getFormattedDate(datePrav.getTime());
	}

	public void setDatePravDate(Date datePrav) {
		this.datePrav = new GregorianCalendar();
		this.datePrav.setTime(datePrav);
	}

	public void setDatePrav(GregorianCalendar datePrav) {
		this.datePrav = datePrav;
	}

	public int getLgota() {
		return lgota;
	}

	public void setLgota(int lgota) {
		this.lgota = lgota;
	}

	public Period getPeriodNS() {
		if (periodNS != null)
			return periodNS;
		else
			return new Period(0, 0, 0);
	}

}
