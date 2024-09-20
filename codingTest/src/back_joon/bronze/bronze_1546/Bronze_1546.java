package back_joon.bronze.bronze_1546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze_1546 {
	public static void main(String[] args) throws IOException {
		BufferedReader     br = new BufferedReader(new InputStreamReader(System.in));
		int             count = Integer.parseInt(br.readLine());
		StringTokenizer    st = new StringTokenizer(br.readLine());
		double[]       scores = new double[count];
		double              m = 0;
		double          total = 0;
		double        average = 0;
		
		for(int i=0; i<count; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}
		
		for(double score : scores) {
			if(score > m) {
				m = score;
			}
		}
		
		for(double score : scores) {
			score = score/m*100;
			total += score;
		}
		
		average = total / count;
		
		System.out.println(average);
	}
}
