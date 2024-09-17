package back_joon.bronze.bronze_1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Bronze_1157 {
	public static void main(String[] args) throws IOException {
		BufferedReader                    br = new BufferedReader(new InputStreamReader(System.in));
		char[]                     alphabets = br.readLine().toUpperCase().toCharArray();
		Map<String, Integer> alphabetToCount = new HashMap<String, Integer>();
		int                         maxCount = 0;
		String                  manyAlphabet = "?"; 
		
		for(char alphabet : alphabets) {
			String strAlpha = String.valueOf(alphabet);
			int       count = alphabetToCount.containsKey(strAlpha) ? alphabetToCount.get(strAlpha) + 1 : 1;
			
			alphabetToCount.put(strAlpha, count);
		}
		
		for(String key : alphabetToCount.keySet()) {
			int count = alphabetToCount.get(key);
			
			if(count > maxCount) {
				manyAlphabet = key;
				maxCount     = count;
			} else if(count == maxCount) {
				manyAlphabet = "?";
			}
		}
		
		System.out.println(manyAlphabet);
	}
}
