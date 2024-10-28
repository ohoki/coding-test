package back_joon.silver.silver_1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class wordLengthComparator implements Comparator<String> {
	@Override    
	public int compare(String word1, String word2) {
		if (word1.length() > word2.length()) {
			return 1;        
		} else if (word1.length() < word2.length()) {
			return -1;
		} else {
			return word1.compareTo(word2);
		}
	}
}

public class silver_1181 {
	public static void main(String[] args) throws IOException {
		List<String> words = new ArrayList<String>();
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int              n = Integer.valueOf(br.readLine());
		
		for(int i=0; i<n; i++) {
			words.add(br.readLine());
		}
		
		words = words.stream().distinct().collect(Collectors.toList());
		
		Collections.sort(words, new wordLengthComparator());
		
		for(String word : words) {
			System.out.println(word);
		}
	}	
}
