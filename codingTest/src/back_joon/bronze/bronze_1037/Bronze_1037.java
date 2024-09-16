package back_joon.bronze.bronze_1037;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze_1037 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int        number = Integer.parseInt(br.readLine());
		String[] divisors = br.readLine().split(" ");
		int           min = Integer.parseInt(divisors[0]);
		int           max = Integer.parseInt(divisors[number-1]);
		
		for(int i=0; i<number; i++) {
			int a = Integer.parseInt(divisors[i]);
			
			min = min > a ? a : min;
			max = max > a ? max : a;
		}
		
		System.out.println(min * max);	
	}
}
