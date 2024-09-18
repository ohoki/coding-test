package back_joon.bronze.bronze_1292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze_1292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]   indexs = br.readLine().split(" ");
		int    firstIndex = Integer.parseInt(indexs[0]);
		int     lastIndex = Integer.parseInt(indexs[1]);
		int         count = 0; 
		int        result = 0;     
		
		for(int i=1; i<=1000; i++) {
			for(int j=1; j<=i; j++) {
				count++;
				
				if(firstIndex <= count && count <= lastIndex) {
					result += i;
				}
			}
			if(count > lastIndex) break;
		}
		
		System.out.println(result);
	}
}
