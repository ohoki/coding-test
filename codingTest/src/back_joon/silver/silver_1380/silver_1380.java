package back_joon.silver.silver_1380;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class silver_1380 {
	public static void main(String[] args) throws IOException {
		BufferedReader           br = new BufferedReader(new InputStreamReader(System.in));
		int notGetBackStudentNumber = 1;      
		
		while(true) {
			int                                    n = Integer.parseInt(br.readLine());
			String[]                        students = new String[n+1];
			Map<Integer, String> confiscatedStudents = new HashMap<Integer, String>();
			String                            result = "";
			
			if(n == 0) {
				break;
			}
			
			for(int i=0; i<=n; i++) {
				students[i] = i == 0 ? "" : br.readLine(); 
			}
			
			for(int i=0; i<2*n-1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int         number = Integer.parseInt(st.nextToken());
				
				if(confiscatedStudents.containsKey(number)) {
					confiscatedStudents.remove(number); 
				} else {
					confiscatedStudents.put(number, students[number]);
				}
			}
			
			for(int i : confiscatedStudents.keySet()) {
				result = confiscatedStudents.get(i);
			}
			
			System.out.println(notGetBackStudentNumber + " " + result);
			notGetBackStudentNumber++;
		}
	}
}
