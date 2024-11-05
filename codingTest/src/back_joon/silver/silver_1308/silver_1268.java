package back_joon.silver.silver_1308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Days {
	int todayYear;
	int todayMonth;
	int todayDay;
	int dDayYear;
	int dDayMonth;
	int dDayDay;
	
	public Days(int todayYear, int todayMonth, int todayDay, int dDayYear, int dDayMonth, int dDayDay) {
		this.todayYear  = todayYear;
		this.todayMonth = todayMonth;
		this.todayDay   = todayDay;
		this.dDayYear   = dDayYear;
		this.dDayMonth  = dDayMonth;
		this.dDayDay    = dDayDay;
	}
	
	public boolean isOverThousandYears() {
		return this.dDayYear - this.todayYear > 1000 
				|| (this.dDayYear - this.todayYear == 1000 
					&& (this.dDayMonth > this.todayMonth 
					|| (this.dDayMonth == this.todayMonth 
						&& this.dDayDay >= this.todayDay)));
	}
	
	public int calculateDurationDate() {
		return calculateDays(this.dDayYear, this.dDayMonth, this.dDayDay) - calculateDays(this.todayYear, this.todayMonth, this.todayDay);
	}
	
	private static int checkYundal(int year) {
		if((year%4 == 0 && year%100 != 0) || year%400 == 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	private static int calculateDays(int year, int month, int day) {
		int[] daysFromMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int          result = 0;
		
		for(int i=1; i<year; i++) {
			result += 365 + checkYundal(i);
		}
		
		for(int i=1; i<month; i++) {
			result += daysFromMonth[i] + (i==2 ? checkYundal(year) : 0);
		}
		
		result += day;
		
		return result;
	}
}

public class silver_1268 {
	public static void main(String[] args) throws IOException {
		BufferedReader   br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int       todayYear = Integer.valueOf(st1.nextToken());
		int      todayMonth = Integer.valueOf(st1.nextToken());
		int        todayDay = Integer.valueOf(st1.nextToken());
		int        dDayYear = Integer.valueOf(st2.nextToken());
		int       dDayMonth = Integer.valueOf(st2.nextToken());
		int         dDayDay = Integer.valueOf(st2.nextToken());
		Days           days = new Days(todayYear, todayMonth, todayDay, dDayYear, dDayMonth, dDayDay);
		
		if(days.isOverThousandYears()) {
			System.out.println("gg");
		} else {
			System.out.println("D-" + days.calculateDurationDate());
		}
	}
}
