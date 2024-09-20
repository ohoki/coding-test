package back_joon.bronze.bronze_1526;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze_1526 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int        number = Integer.parseInt(br.readLine());
		String     result = "";
		
		for(int i=number; i>=4; i--) {
			String unknownNumber = String.valueOf(i);
			
			unknownNumber = unknownNumber.replace("4", "");
			unknownNumber = unknownNumber.replace("7", "");
			
			if("".equals(unknownNumber)) {
				result = String.valueOf(i);
				break;
			}
		}
		
		System.out.println(result);
	}
}
