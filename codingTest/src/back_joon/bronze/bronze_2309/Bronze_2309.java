package back_joon.bronze.bronze_2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bronze_2309 {
	public static void main(String[] args) throws IOException {
		BufferedReader     br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> manList = new ArrayList<Integer>();
		int               sum = 0;
		int              aIdx = 0;
		int              bIdx = 0;
		
		for(int i=0; i<9; i++) {
			manList.add(Integer.parseInt(br.readLine()));
			sum += manList.get(i);
		}
		
		Collections.sort(manList);
		
		loop1:
		for(int i=0; i<manList.size(); i++) {
			for(int j=i+1; j<manList.size(); j++) {
				if( (sum - manList.get(i) - manList.get(j)) == 100) {
					aIdx = i;
					bIdx = j;
					break loop1;
				}
			}
		}
		
		for(int i=0; i<manList.size(); i++) {
			if(i != aIdx && i != bIdx) {
				System.out.println(manList.get(i));
			}
		}
		
	}
}
