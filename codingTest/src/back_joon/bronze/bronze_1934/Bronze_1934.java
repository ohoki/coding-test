package back_joon.bronze.bronze_1934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze_1934 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int         count = Integer.valueOf(br.readLine());
		
		for(int i=0; i<count; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int              a = Integer.valueOf(st.nextToken());
			int              b = Integer.valueOf(st.nextToken());
			int              k = 1;
			int    smallNumber = a > b ? b : a;
			int multipleNumber = smallNumber;
			boolean    isFound = false;
			
			while (!isFound) {
				if(multipleNumber%a == 0 && multipleNumber%b == 0) {
					isFound = true;
				} else {
					multipleNumber = smallNumber * ++k;
				}
			}
			
			System.out.println(multipleNumber);
		}
	}
}
