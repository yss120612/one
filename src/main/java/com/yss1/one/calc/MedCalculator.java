package com.yss1.one.calc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yss1.one.dao.LgotaDescrDao;
import com.yss1.one.models.LgotaDescription;
import com.yss1.one.models.LgotaUnion;
import com.yss1.one.models.Staj;
import com.yss1.one.util.Period;
import com.yss1.one.util.Utils;

//Калькулятор расчета медицинского стажа
@Service
public class MedCalculator {
	@Autowired
	LgotaDescrDao lDao;
	
//	public Period getMedStajBefore(List<Staj> ls, Date bd, boolean containsCity) {
//		// what=1 ГД,what=2 СМ, what=3 ГДХР, what=4 СМХР
//
//		Period per = new Period(0, 0, 0);
//		Date border = Utils.makeDate(1999, 11, 1);
//		for (Staj st : ls) {
//			if (st.getStartDate().after(bd))
//				continue;
//			
//			if ( st.getCspext().contains("СМХР")) {
//				if (containsCity) {
//					if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
//						per.addPeriod(Utils.multPeriod(
//								Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()), 1.75f));
//					} else {
//						per.addPeriod(Utils.multPeriod(Utils.makePeriod(st.getStartDate(), bd, 0), 1.75f));
//					}
//				} else {
//					if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
//						per.addPeriod(Utils.multPeriod(
//								Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()), 1.5f));
//					} else {
//						per.addPeriod(Utils.multPeriod(Utils.makePeriod(st.getStartDate(), bd, 0), 1.5f));
//					}
//				}
//				
//			} else if (st.getCspext().contains("ГДХР")) {
//				if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
//					per.addPeriod(Utils.multPeriod(Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()),1.5f));
//				} else {
//					per.addPeriod(Utils.multPeriod(Utils.makePeriod(st.getStartDate(), bd, 0), 1.5f));
//				}
//
//			} else if (st.getCspext().contains("СМ")) {
//				if (containsCity) {
//					if (st.getStartDate().before(border)) {
//						if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
//							per.addPeriod(Utils.multPeriod(Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()), 1.25f));
//							//per.addPeriod(Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()));
//						} else {
//							per.addPeriod(Utils.multPeriod(Utils.makePeriod(st.getStartDate(), bd, 0), 1.25f));
//							//per.addPeriod(Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()));
//						}
//					} else {
//						if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
//							per.addPeriod(Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()));
//						} else {
//							per.addPeriod(Utils.makePeriod(st.getStartDate(), bd, 0));
//						}
//					}
//				} else {
//					if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
//						per.addPeriod(Utils.multPeriod(
//								Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()), 1.25f));
//					} else {
//						per.addPeriod(Utils.multPeriod(Utils.makePeriod(st.getStartDate(), bd, 0), 1.25f));
//					}
//				}
//				
//			} else if (st.getCspext().contains("ГД")) {
//				if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
//					per.addPeriod(Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()));
//				} else {
//					per.addPeriod(Utils.makePeriod(st.getStartDate(), bd, 0));
//				}
//			}
//
//		}
//		return per;
//	}

	private Date dfrom=Utils.makeDate(1999,11,1);
	
	public Period getMedStajBefore(List<Staj> ls, Date bd, String ms) {
		Period per = new Period(0, 0, 0);
		for (Staj st : ls) {
			if (st.getStartDate().after(bd) ||  !st.getCspext().equals(ms))
				continue;
			
			
					if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
						per.addPeriod(Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()));
					} else {
						per.addPeriod(Utils.makePeriod(st.getStartDate(), bd, 0));
					}
			
		}
		return per;
	}
	
	
	public Period getMedStajAfter(List<Staj> ls, Date bd, String ms) {
		Period per = new Period(0, 0, 0);
		for (Staj st : ls) {
			if (st.getEndDate().before(bd) || !st.getCspext().equals(ms))
				continue;
			
					if (Utils.afterOrEqual(st.getStartDate(), bd)) {
						per.addPeriod(Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()));
					} else {
						per.addPeriod(Utils.makePeriod(bd,st.getEndDate(), 0));
					}
					}
		return per;
	}
	
	
	public Period getMedStajAll(List<Staj> ls,String what) {
		
		//"СМХР""ГДХР""ГД""СМ"
		
		Period st1=getMedStajBefore(ls, Utils.makeDate(1999, 11, 1),"СМХР").multPeriod(1.25f);
		Period st2=getMedStajAfter(ls, Utils.makeDate(1999, 11, 1),"СМХР");
		
		Period st3=getMedStajBefore(ls, Utils.makeDate(1999, 11, 1),"СМ");
		Period st4=getMedStajAfter(ls, Utils.makeDate(1999, 11, 1),"СМ");
		
		Period st5=getMedStajBefore(ls, Utils.makeDate(1999, 11, 1),"ГДХР").multPeriod(1.5f);
		Period st6=getMedStajAfter(ls, Utils.makeDate(1999, 11, 1),"ГДХР").multPeriod(1.5f);
		
		Period st7=getMedStajBefore(ls, Utils.makeDate(1999, 11, 1),"ГД");
		Period st8=getMedStajAfter(ls, Utils.makeDate(1999, 11, 1),"ГД");
		
		boolean containsCity=!st5.isEmpty()||!st6.isEmpty()||!st7.isEmpty()||!st8.isEmpty();
		if (what.equals("СМ")) {
			if (!containsCity) st4=st4.multPeriod(1.25f);
		}
		
		if (what.equals("СМХР")) {
			if (!containsCity) {
			st1=st1.multPeriod(1.5f);
			st2=st2.multPeriod(1.5f);
			}
			else
			{
				st1=st1.multPeriod(1.75f);
				st2=st2.multPeriod(1.75f);
			}
		}
		
		
		
		//Period atAll=getMedStajBefore(ls, Utils.makeDate(2100, 1, 1));
		
		return getMedStajBefore(ls, Utils.makeDate(2100, 1, 1),what);
	}

	private boolean inList(LgotaDescription ld, String patt) {
		
		if (ld.getName().equals(patt)) return true;
		if (ld.getForSumm()==null) return false;
		for (LgotaUnion lu: ld.getForSumm()) {
			if(lu.getCode().equals(patt)) {
				ld.setSummUsed(true);
				return true;
			}
		}
		return false;
	}

	public Period getMedStaj(List<Staj> stl,String vid) {
	LgotaDescription lg=lDao.getLgota(vid);
	if (stl==null) return new Period(0,0,0);
	List<Staj> sttmp=new ArrayList<Staj>();
	float stavka;
	Staj current,stg1=null;
	
	//отбираем только с нужным кодом которые или имеют ставку или до 01-11-1999г.
	for (Staj st: stl) {
		
		if (inList(lg,st.getCspext()))
		{
			current=new Staj(st);
			if (st.getStartDate().before(dfrom)) {
				if (st.getEndDate().after(dfrom)) {
					current.setStavka(1f);
					current.setEndDate(Utils.addDay(dfrom,-1));
					current.setAddDay(0);
					sttmp.add(current);
					
					current=new Staj(st);
					current.setStartDate(dfrom);
				}
				else
				{
					current.setStavka(1f);
					sttmp.add(current);
					continue;
				}
			}
			stavka=Utils.getFloat(current.getDopcspext());
			if (stavka>0) {
				current.setStavka(stavka);
				sttmp.add(current);
			}
		}
	
	}
	if (sttmp.isEmpty()) return new Period(0,0,0);
	Collections.sort(sttmp);
	
	List<Staj> toadd1=new ArrayList<Staj>();
	List<Staj> toadd2=new ArrayList<Staj>();
	List<Staj> toadd3=new ArrayList<Staj>();
	int counter=0;
	boolean changed;
	//int aaa=0;
	
	for (Staj s0:sttmp) s0.setNumb(++counter);;
	for (Staj s0:sttmp) toadd1.add(Staj.makeCopy(s0));
	for (Staj s0:sttmp) toadd2.add(Staj.makeCopy(s0));
	
	while(true)
	{
	changed=false;
	//System.out.println("counter="+counter++);
	for (Staj s1:toadd1) {
		//System.out.println("toadd="+toadd3.size());
		toadd3.clear();
		for (Staj s2:toadd2) {
			if(s1.getNumb()==s2.getNumb()) continue;
			current=null;
			if (Utils.intersect(s1.getStartDate(),s1.getEndDate(),s2.getStartDate(),s2.getEndDate())) {
				//System.out.println("s1s="+s1.getStartDate()+", s1f="+s1.getEndDate()+", s2s="+s2.getStartDate()+", s2f"+s2.getEndDate());
				changed=true;
				current=Staj.makeCopy(s1);
				current.setNumb(++counter);
				
				if (Utils.beforeOrEqual(s1.getStartDate(),s2.getStartDate()))
				{
					current.setStartDate(s2.getStartDate());
					s1.setEndDate(Utils.addDay(s2.getStartDate(),-1));
					
				}
				else {
					current.setStartDate(s1.getStartDate());
					s2.setEndDate(Utils.addDay(s1.getStartDate(),-1));
				}
				
				if (Utils.beforeOrEqual(s1.getEndDate(),s2.getEndDate()))
				{
					current.setEndDate(s1.getEndDate());
					s2.setStartDate(Utils.addDay(s1.getEndDate(),1));
					
				}
				else {
					current.setStartDate(s2.getEndDate());
					s1.setStartDate(Utils.addDay(s2.getEndDate(),1));
				}

				current.setCspext(s1.getCspext()+","+s2.getCspext());
				
				if (current.getStartDate().before(dfrom)) {
					current.setStavka(1f);
				}
				else {
					current.setStavka(s1.getStavka()+s2.getStavka());
					
				}
				toadd3.add(current);
			}
	
				
			}
		toadd2.addAll(toadd3);
		toadd2.removeIf(x->!x.getStartDate().before(x.getEndDate()));
		}
		toadd1.removeIf(x->!x.getStartDate().before(x.getEndDate()));
	if (!changed) break;
	}
	
	for(Staj s1:toadd2) setLgota(s1);
	toadd1.removeIf(x->x.getStavka()<0.01f);
	

	return getMedStajAll(sttmp,lg.getName());
}

	
private void setLgota(Staj s1) {
	// TODO Auto-generated method stub
	Set<String>  csp= new HashSet<String>();
	String [] csarr = s1.getCspext().split(",");
	for (int i=0;i<csarr.length;i++) csp.add(csarr[i]);
	
	if (s1.getStartDate().before(dfrom)) {
		if (csp.contains("27-СМХР")) {s1.setCspext("27-СМХР");} else 
		if (csp.contains("27-ГДХР")) {s1.setCspext("27-ГДХР");} else			
		if (csp.contains("27-СМ")) {s1.setCspext("27-СМ");} else
		{s1.setCspext("27-ГД");}
		
	}
	else {

		if (csp.contains("27-СМХР") && csp.size()==1) {
			if (s1.getStavka()<0.99f)
			{
							s1.setCspext("27-ГДХР");
							s1.setStavka(1f);
			}
		}
		else if (csp.contains("27-ГДХР")&&csp.contains("27-СМХР") && csp.size()==2) {
			if (s1.getStavka()<0.99f)
			{
				s1.setCspext("27-СМ");
				s1.setStavka(1f);
			}
			else s1.setCspext("27-ГДХР");
		}
		else if (csp.contains("27-ГДХР")&&csp.contains("27-СМХР")&&csp.contains("27-СМ") && csp.size()==3) {
			if (s1.getStavka()<0.99f) { 
				s1.setCspext("27-ГД");
				s1.setStavka(1f);
			}
			else s1.setCspext("27-СМ");
		}
		else {
			if (s1.getStavka()<0.99f) s1.setStavka(0f);
			s1.setCspext("27-ГД");
		}
	}
	
}



//	private String selectMedStaj(Staj a, Staj b) {
//	if (a.getCspext().equals("27-ГД")||b.getCspext().equals("27-ГД")) return "27-ГД";
//	else if (a.getCspext().equals("27-СМ")||b.getCspext().equals("27-СМ")) return "27-СМ";
//	else if (a.getCspext().equals("27-ГДХР")||b.getCspext().equals("27-ГДХР")) return "27-ГДХР";
//	else if (a.getCspext().equals("27-СМХР")||b.getCspext().equals("27-СМХР")) return "27-СМХР";
//	else return "";
//}
	
}
