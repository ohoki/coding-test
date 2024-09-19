package back_joon.bronze.bronze_1357;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze_1357 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]  numbers = br.readLine().split(" ");
		int             x = Integer.parseInt(numbers[0]);
		int             y = Integer.parseInt(numbers[1]);
		int        result = 0;
		
		result = reverseInt(reverseInt(x) + reverseInt(y));
		
		System.out.println(result);
	}
	
	public static int reverseInt(int number) {
		int reverseNumber = 0;
		
		while (number > 0) {
			int remain = number % 10;
			reverseNumber = reverseNumber * 10 + remain;
			number /= 10;
		}
		
		return reverseNumber;
	}
}
