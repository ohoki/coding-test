package back_joon.silver.silver_1251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class silver_1251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String       word = br.readLine();
		String     result = "";
		
		for(int i=1; i<word.length(); i++) {
			for(int j=word.length()-1; j>i; j--) {
				StringBuilder  firstWord = new StringBuilder(word.substring(0, i)).reverse();
				StringBuilder secondWord = new StringBuilder(word.substring(i, j)).reverse();
				StringBuilder  thirdWord = new StringBuilder(word.substring(j, word.length())).reverse();
				String           sumWord = firstWord.append(secondWord).append(thirdWord).toString();

				if(i == 1 && j == word.length()-1) {
					result = sumWord; 
				} else if(result.compareTo(sumWord) > 0) {
					result = sumWord;
				}
			}
		}
		
		System.out.println(result);
	}	
}
