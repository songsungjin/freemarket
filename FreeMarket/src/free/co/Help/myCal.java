package free.co.Help;

import java.io.Serializable;
import java.util.Calendar;

public class myCal implements Serializable{
	
	private int year = -100;
	private int month = -100;
	private int day = -100;
	private int lastday;
	private int dayOfweek;
	
	private int hour = 0;
	private int min = 0;
	
	Calendar cal = Calendar.getInstance();
	
	public myCal() {}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getLastday() {
		return lastday;
	}

	public void setLastday(int lastday) {
		this.lastday = lastday;
	}

	public int getDayOfweek() {
		return dayOfweek;
	}

	public void setDayOfweek(int dayOfweek) {
		this.dayOfweek = dayOfweek;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public Calendar getCal() {
		return cal;
	}

	public void setCal(Calendar cal) {
		this.cal = cal;
	}

	@Override
	public String toString() {
		return "myCal [year=" + year + ", month=" + month + ", day=" + day + ", lastday=" + lastday + ", dayOfweek="
				+ dayOfweek + ", hour=" + hour + ", min=" + min + ", cal=" + cal + "]";
	}
	
	public void calculate(){
		if(month == 0){
			this.year--;
			this.month = 12;
		}else if(month == 13){
			this.year++;
			this.month = 1;
		}else if(month < 0){
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH)+1;
			if(day < 0){
				day = cal.get(Calendar.DATE);
			}
		}
		
		cal.set(this.year,this.month-1,1);
		dayOfweek = cal.get(Calendar.DAY_OF_WEEK);
		lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
}