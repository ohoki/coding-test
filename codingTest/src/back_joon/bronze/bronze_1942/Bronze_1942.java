package back_joon.bronze.bronze_1942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze_1942 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String[] startTime = st.nextToken().split(":"); //hh:mm:ss
			String[]   endTime = st.nextToken().split(":"); //hh:mm:ss
			int             h1 = Integer.valueOf(startTime[0]);
			int             m1 = Integer.valueOf(startTime[1]);
			int             s1 = Integer.valueOf(startTime[2]);
			int             h2 = Integer.valueOf(endTime[0]);
			int             m2 = Integer.valueOf(endTime[1]);
			int             s2 = Integer.valueOf(endTime[2]);
			int         result = 0;
			
			while(true) {
				if(s1 == 60) {
					s1 = 0; m1 += 1;
				}
				if(m1 == 60) {
					m1 = 0; h1 += 1;
				}
				if(h1 == 24) {
					h1 = 0;
				}
				
				int timeNumber = h1 * 10000 + m1 * 100 + s1;
				
				if(timeNumber % 3 == 0) result++;
				
				if(h1 == h2 && m1 == m2 && s1 == s2) {
					break;
				} else {
					s1++;
				}
			}
			System.out.println(result);
		}
	}
}
