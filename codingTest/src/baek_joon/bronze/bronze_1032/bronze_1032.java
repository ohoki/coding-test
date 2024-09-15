package baek_joon.bronze.bronze_1032;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bronze_1032 {
	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int         number = Integer.parseInt(br.readLine());
		char[]     pattern = br.readLine().toCharArray();
		
		for(int i=0; i<number-1; i++) {
			char[] fileNmae = br.readLine().toCharArray();
			
			for(int j=0; j<pattern.length; j++) {
				if(pattern[j] != fileNmae[j]) {
					pattern[j] = '?';
				}
			}
		}
		
		System.out.println(pattern);
	}
}


