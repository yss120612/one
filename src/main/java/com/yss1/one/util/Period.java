package com.yss1.one.util;

//модель для хранения любого периода в формате дни/месяцы/годы
//умеет себя складывать с другим и умножать на коэффициент
public class Period {
	public Period(int years, int months, int days) {
		this.years = years;
		this.months = months;
		this.days = days;
	}

	public Period(Period other) {
		if (other == null) {
			this.years = 0;
			this.months = 0;
			this.days = 0;
		} else {
			this.years = other.getYears();
			this.months = other.getMonths();
			this.days = other.getDays();
		}
	}

	@Override
	public String toString() {
		return "{" + years + " / " + months + " / " + days + "}";
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	// прибавляет к текущему периоду другой
	public void addPeriod(Period p) {
		if (p == null) {

			return;
		}
		this.years += p.getYears();
		this.months += p.getMonths();
		this.days += p.getDays();

		years = years + (months + days / 30) / 12;
		months = (months + days / 30) % 12;
		days = days % 30;
	}

	//превышает ли текущий период переданный в годах
	public boolean isMore(float year) {
		return (year*12+0.1f)>(years*12+months);
	}
	
	// отнимает от текущего периода другой
	public void diffPeriod(Period p) {
		if (p == null) {

			return;
		}
		this.days -= p.getDays();
		if (this.days < 0) {
			this.days += 30;
			this.months--;
		}
		while (this.days >= 30) {
			this.days -= 30;
			this.months--;
		}

		if (this.days < 0)
			this.days += 30;

		this.months -= p.getMonths();
		if (this.months < 0) {
			this.months += 12;
			this.years--;
		}
		while (this.months >= 12) {
			this.months -= 12;
			this.years--;
		}
		if (this.months < 0)
			this.months += 12;
		this.years -= p.getYears();
	}

	// возвращает новый период в виде себя умноженного на коэффициент. текущий не
	// изменяет
	public Period multPeriod(float mult) {
		return Utils.multPeriod(this, mult);
	}

	public boolean isEmpty() {
		return years>0||days>0||months>0;
	}
	
	private int years;
	private int months;
	private int days;
}
