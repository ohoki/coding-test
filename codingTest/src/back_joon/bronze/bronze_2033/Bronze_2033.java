package back_joon.bronze.bronze_2033;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze_2033 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String          n = br.readLine();
		int        result = Integer.parseInt(n);
		double  numerator = 10.0;
		
		if(n.length() >= 2) {
			for(int i=1; i<n.length(); i++) {
				result    = (int)(Math.round(result/numerator) * numerator);
				numerator = Math.pow(10, i+1);
			}
		}
		
		System.out.println(result);
	}
}
