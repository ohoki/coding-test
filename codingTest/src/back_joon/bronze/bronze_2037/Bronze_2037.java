package back_joon.bronze.bronze_2037;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze_2037 {
	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int              p = Integer.valueOf(st.nextToken());
		int              w = Integer.valueOf(st.nextToken());
		int           time = 0;
		int   beforePadIdx = 0;
		String     message = br.readLine();
		String[]    keypad = {
				" "   , "ABC", "DEF",
				"GHI" , "JKL", "MNO",
				"PQRS", "TUV", "WXYZX"
		}; 
		
		for(int i=0; i<message.length(); i++) {
			char ch = message.charAt(i);
			
			for(int j=0; j<keypad.length; j++) {
				int idx = keypad[j].indexOf(ch);
				
				if(idx >= 0) {
					if(beforePadIdx == j && beforePadIdx != 0) {
						time += w;
					} else {
						beforePadIdx = j;
					}
					time += (p + p*idx);
					break;
				} 
			}
		}
		
		System.out.println(time);
	}
}
