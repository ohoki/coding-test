package back_joon.bronze.bronze_2160;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze_2160 {
	public static void main(String[] args) throws IOException {
		BufferedReader      br = new BufferedReader(new InputStreamReader(System.in));
		int                  n = Integer.valueOf(br.readLine());
		Character[][]   paints = new Character[n][35];
		String           paint = null;
		int           minCount = 36;
		int      firstPaintIdx = 0;
		int     secondPaintIdx = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<35; j++) {
				int idx = j%7; 
				if(idx == 0) { 
					paint = br.readLine(); 
				}
				paints[i][j] = paint.charAt(idx);
			}
		}
		
		for(int i=0; i<paints.length; i++) {
			for(int j=i+1; j<paints.length; j++) {
				int count = 0;
				
				for(int k=0; k<35; k++) {
					if(paints[i][k] != paints[j][k]) {
						count++;
					}
				}
				
				if(minCount > count) {
					minCount = count;
					firstPaintIdx = i+1;
					secondPaintIdx = j+1;
				}
			}
		}
		
		System.out.println(firstPaintIdx + " " + secondPaintIdx);
	}
}
