package back_joon.bronze.bronze_2435;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bronze_2435 {
	public static void main(String[] args) throws IOException {
		BufferedReader          br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer         st = new StringTokenizer(br.readLine());
		int                      n = Integer.valueOf(st.nextToken());
		int                      k = Integer.valueOf(st.nextToken());
		st                         = new StringTokenizer(br.readLine());
		List<Integer> temperatures = new ArrayList<Integer>();
		int                 result = -200;
		
		while (st.hasMoreElements()) {
			temperatures.add(Integer.valueOf(st.nextToken()));
		}
		
		for(int i=0; i<=n-k; i++) {
			int sum = 0;
			
			for(int j=i; j<i+k; j++) {
				sum += temperatures.get(j);
			}
			
			if(result < sum) {
				result = sum;
			}
		}
		
		System.out.println(result);
	}
}
