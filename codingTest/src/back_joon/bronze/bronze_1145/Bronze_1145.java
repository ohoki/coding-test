package back_joon.bronze.bronze_1145;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze_1145 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]  numbers = br.readLine().split(" ");
		int         count = 0;
		int      multiple = 0;
		
		while (count < 3) {
			count = 0;
			multiple++;
			
			for(int i=0; i<numbers.length; i++) {
				int number = Integer.parseInt(numbers[i]);
				
				if(multiple%number == 0) {
					count ++;
				}
			}
		}
		
		System.out.println(multiple);
	}
}
