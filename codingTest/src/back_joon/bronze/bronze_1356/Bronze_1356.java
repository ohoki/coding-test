package back_joon.bronze.bronze_1356;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze_1356 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[]    numbers = br.readLine().toCharArray();
		String     result = "NO";
		
		if(numbers.length > 1) {
			for(int i=0; i<numbers.length; i++) {
				int frontMultiple = 1;
				int  backMultiple = 1;
				
				for(int j=0; j<=i; j++) {
					frontMultiple *= Integer.parseInt(String.valueOf(numbers[j]));
				}
				for(int k=numbers.length-1; k>i; k--) {
					backMultiple *= Integer.parseInt(String.valueOf(numbers[k]));
				}
				if(frontMultiple == backMultiple) {
					result = "YES";
					break;
				}
			}
		}
		
		System.out.println(result);
	}
}
