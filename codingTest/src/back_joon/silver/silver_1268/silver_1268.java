package back_joon.silver.silver_1268;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class silver_1268 {
	public static void main(String[] args) throws IOException {
		BufferedReader                            br = new BufferedReader(new InputStreamReader(System.in));
		int                          numberOfStudent = Integer.valueOf(br.readLine());
		int[][]                              classes = new int[numberOfStudent][5];
		Map<Integer, Set<Integer>> sameClassStudents = new HashMap<Integer, Set<Integer>>();
		int                             maxSameCount = 0;
		int                                   result = 1;    
		
		for(int i=0; i<numberOfStudent; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<5; j++) {
				classes[i][j] = Integer.valueOf(st.nextToken());
			}
			
			sameClassStudents.put(i+1, new HashSet<Integer>());
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<classes.length; j++) {				
				for(int k=0; k<classes.length; k++) {
					if(j != k && classes[j][i] == classes[k][i]) {
						sameClassStudents.get(j+1).add(k);
					}
				}
			}
		}
		
		for(int i=0; i<sameClassStudents.size(); i++) {
			if(maxSameCount < sameClassStudents.get(i+1).size()) {
				maxSameCount = sameClassStudents.get(i+1).size();
				result = i+1;
			}
		}
		
		System.out.println(result);
	}	
}
