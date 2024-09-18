package back_joon.bronze.bronze_1259;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze_1259 {
	public static void main(String[] args) throws IOException {
		BufferedReader   br = new BufferedReader(new InputStreamReader(System.in));
		Boolean       isEnd = false;
		
		while (!isEnd) {
			String   inputStr = br.readLine();
			StringBuffer   sb = new StringBuffer(inputStr);
			String reverseStr = sb.reverse().toString();
			
			if("0".equals(inputStr)) {
				isEnd = true;
			} else if(reverseStr.equals(inputStr)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
