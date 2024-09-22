package back_joon.bronze.bronze_1816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze_1834 {
	public static void main(String[] args) throws IOException {
		BufferedReader   br = new BufferedReader(new InputStreamReader(System.in));
		long              n = Integer.parseInt(br.readLine());
		long         result = 0;
		
		for(long i=1; i<n; i++) {
			result += ((n * i) + i);
		}
		
		System.out.println(result);
	}
}
