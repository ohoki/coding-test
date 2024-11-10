package back_joon.silver.silver_1340;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Days {
	int year;
	int month;
	int day;
	int hour;
	int minute;
	
	public Days(int year, String month, int day, int hour, int minute) {
		this.year   = year;
		this.month  = caculateMonth(month);
		this.day    = day;
		this.hour   = hour;
		this.minute = minute;
	}
	
	public Double calculateYearProgress() {
		return calculateMinutes(this.year, this.month, this.day, this.hour, this.minute) * 100 / (double)calculateMinutes(this.year, 12, 31, 24, 0);
	}
	
	private int calculateMinutes(int year, int month, int day, int hour, int minute) {
		int[]       daysFromMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int                result = 0;
		final int ONE_DAY_MINUTES = 1440;
		
		for(int i=1; i<month; i++) {
			result += ONE_DAY_MINUTES * (daysFromMonth[i] + (i==2 ? checkYundal(year) : 0));
		}
		
		result += ONE_DAY_MINUTES * (day-1);
		result += hour * 60 + minute;
		
		return result;
	}
	
	private static int checkYundal(int year) {
		if((year%4 == 0 && year%100 != 0) || year%400 == 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	private static int caculateMonth(String monthStr) {
		int result = 0;
		
		switch (monthStr) {
			case "January": {
				result = 1;
				break;
			}
			case "February": {
				result = 2;
				break;
			}
			case "March": {
				result = 3;
				break;
			}
			case "April": {
				result = 4;
				break;
			}
			case "May": {
				result = 5;
				break;
			}
			case "June": {
				result = 6;
				break;
			}
			case "July": {
				result = 7;
				break;
			}
			case "August": {
				result = 8;
				break;
			}
			case "September": {
				result = 9;
				break;
			}
			case "October": {
				result = 10;
				break;
			}
			case "November": {
				result = 11;
				break;
			}
			case "December": {
				result = 12;
				break;
			}
		}
		return result;
	}
}

public class silver_1340 {
	public static void main(String[] args) throws IOException {
		BufferedReader   br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer  st = new StringTokenizer(br.readLine());
		String     monthStr = st.nextToken();
		int             day = Integer.valueOf(st.nextToken().replace(",", ""));
		int            year = Integer.valueOf(st.nextToken());
		String[]       time = st.nextToken().split(":");
		int            hour = Integer.valueOf(time[0]);
		int          minute = Integer.valueOf(time[1]);
		Days           days = new Days(year, monthStr, day, hour, minute);
		
		System.out.println(days.calculateYearProgress());
	}
}
