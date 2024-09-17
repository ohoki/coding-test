package back_joon.bronze.bronze_1110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze_1110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int        number = Integer.parseInt(br.readLine());
		int     newNumber = number;
		int         cycle = 0;
		
		do {
			int  firstNumber = newNumber / 10;
			int secondNumber = newNumber % 10;
			
			if(newNumber >= 10) {
				newNumber =  firstNumber + secondNumber;
			}
			newNumber = (secondNumber*10) + (newNumber%10);
			cycle++;
		} while (number != newNumber);
		
		System.out.println(cycle);
	}
}
