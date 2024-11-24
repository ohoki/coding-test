package back_joon.silver.silver_1476;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class silver_1476 {
	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int    earthNumber = Integer.parseInt(st.nextToken());
		int      sunNumber = Integer.parseInt(st.nextToken());
		int     moonNumber = Integer.parseInt(st.nextToken());
		int         result = 1;
		
		while(true) {
			int earthRemainder = result%15 == 0  ? 15 : result%15;
			int   sunRemainder = result%28 == 0  ? 28 : result%28;
			int  moonRemainder = result%19 == 0  ? 19 : result%19;
			
			if(earthRemainder == earthNumber && 
				 sunRemainder == sunNumber   && 
				moonRemainder == moonNumber) {
				break;
			}
			
			result++;
		}
		
		System.out.println(result);
	}
}
