package back_joon.bronze.bronze_1672;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Bronze_1672 {
	public static void main(String[] args) throws IOException {
		BufferedReader                br = new BufferedReader(new InputStreamReader(System.in));
		int                            n = Integer.parseInt(br.readLine());
		StringBuffer                 dna = new StringBuffer(br.readLine());
		Map<Character, Integer> strToIdx = new HashMap<Character, Integer>();
		String[][]                 table = {{"A","C","A","G"},
							                {"C","G","T","A"},
							                {"A","T","C","G"},
							                {"G","A","G","T"}};
		
		strToIdx.put('A', 0);
		strToIdx.put('G', 1);
		strToIdx.put('C', 2);
		strToIdx.put('T', 3);
				
		while (dna.length() >= 2) {
			int    row = strToIdx.get(dna.charAt(dna.length()-2));
			int column = strToIdx.get(dna.charAt(dna.length()-1));
			
			dna.delete(dna.length()-2, dna.length());
			dna.append(table[row][column]);
		}
		
		System.out.println(dna);
	}
}
