package back_joon.bronze.bronze_1924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.StringTokenizer;

public class Bronze_1924 {
	public static void main(String[] args) throws IOException {
		BufferedReader   br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer  st = new StringTokenizer(br.readLine());
		int           month = Integer.valueOf(st.nextToken());
		int             day = Integer.valueOf(st.nextToken());
		LocalDate      date = LocalDate.of(2007, month, day);
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		int dayOfWeekNumber = dayOfWeek.getValue();
		String       result = ""; 
		
		switch (dayOfWeekNumber) {
		case 1: {
			result = "MON";
			break;
		}
		case 2: {
			result = "TUE";
			break;
		}
		case 3: {
			result = "WED";
			break;
		}
		case 4: {
			result = "THU";
			break;
		}
		case 5: {
			result = "FRI";
			break;
		}
		case 6: {
			result = "SAT";
			break;
		}
		default:
			result = "SUN";
			break;
		}
		
		System.out.println(result);
	}
}
