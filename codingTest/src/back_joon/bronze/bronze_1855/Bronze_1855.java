package back_joon.bronze.bronze_1855;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze_1855 {
	public static void main(String[] args) throws IOException {
		BufferedReader   br = new BufferedReader(new InputStreamReader(System.in));
		int          column = Integer.parseInt(br.readLine());
		char[]     password = br.readLine().toCharArray();
		int             row = password.length/column;
		char[][]     string = new char[row][column];
		int               k = 0;
		StringBuffer result = new StringBuffer();
		
		for(int i=0; i<row; i++) {
			if(i%2 == 0) {
				for(int j=0; j<column; j++) {
					string[i][j] = password[k];
					k++;
				}
			} else {
				for(int j=column-1; j>=0; j--) {
					string[i][j] = password[k];
					k++;
				}
			}
		}
		
		for(int i=0; i<column; i++) {
			for(int j=0; j<row; j++) {
				result.append(string[j][i]);
			}
		}
		
		System.out.println(result);
	}
}
