package back_joon.bronze.bronze_1373;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Bronze_1373 {
	public static void main(String[] args) throws IOException {
		BufferedReader       br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger binaryNumber = new BigInteger(br.readLine(), 2);
		String      octalNumber = binaryNumber.toString(8);
 		
		
		System.out.println(octalNumber);
	}
}
