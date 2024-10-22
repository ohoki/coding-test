package back_joon.bronze.bronze_2684;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze_2684 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int             p = Integer.valueOf(br.readLine());
		
		for(int i=0; i<p; i++) {
			int[]    counts = new int[]{0,0,0,0,0,0,0,0};
			String coinCase = br.readLine();
			
			for(int j=0; j<coinCase.length()-2; j++) {
				String char3 = coinCase.substring(j, j+3);
				
				switch (char3) {
				case "TTT": 
					counts[0]++;
					break;
				case "TTH":
					counts[1]++;
					break;
				case "THT": 
					counts[2]++;
					break;
				case "THH": 
					counts[3]++;
					break;
				case "HTT": 
					counts[4]++;
					break;
				case "HTH": 
					counts[5]++;
					break;
				case "HHT": 
					counts[6]++;
					break;
				case "HHH": 
					counts[7]++;
					break;
				}
			}
			
			for(int j=0; j<counts.length; j++) {
				if(j == counts.length-1) {
					System.out.print(counts[j]);
				} else {
					System.out.print(counts[j] + " ");
				}
				
			}
			
			System.out.println();
		}
	}
}
