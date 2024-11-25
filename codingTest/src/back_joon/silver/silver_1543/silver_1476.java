package back_joon.silver.silver_1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class silver_1476 {
	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		String        docs = br.readLine();
		String     keyword = br.readLine();
		int         result = ( docs.length() - docs.replace(keyword, "").length() ) / keyword.length();
		
		System.out.println(result);
	}
}
