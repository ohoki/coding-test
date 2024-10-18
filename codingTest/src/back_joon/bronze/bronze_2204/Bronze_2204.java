package back_joon.bronze.bronze_2204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bronze_2204 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int n = Integer.valueOf(br.readLine());
			
			if(n == 0) {
				break;
			} else {
				List<String> words = new ArrayList<String>();
				Map<String, String> mapLowerCase = new HashMap<String, String>(); 
				
				for(int i=0; i<n; i++) {
					String      word = br.readLine();
					String lowerWord = word.toLowerCase();
					
					words.add(lowerWord);
					mapLowerCase.put(lowerWord, word);
				}
				
				Collections.sort(words);
				
				System.out.println(mapLowerCase.get(words.get(0)));
			}
		}
	}
}
