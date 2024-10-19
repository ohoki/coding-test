package back_joon.bronze.bronze_2246;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Bronze_2246 {
	public static void main(String[] args) throws IOException {
		BufferedReader                 br = new BufferedReader(new InputStreamReader(System.in));
		int                             n = Integer.valueOf(br.readLine());
		List<Map<String, Integer>> condos = new ArrayList<Map<String, Integer>>();
		int                        result = 0;
		
		for(int i=0; i<n; i++) {
			Map<String, Integer> condo = new HashMap<String, Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			condo.put("distance", Integer.valueOf(st.nextToken()));
			condo.put("price", Integer.valueOf(st.nextToken()));
			
			condos.add(condo);
		}
		
		for(int i=0; i<condos.size(); i++) {
			boolean isPronunciation = true;
			
			for(int j=0; j<condos.size(); j++) {	
				if(i==j) {
					continue;
				}
				if( (condos.get(i).get("distance") > condos.get(j).get("distance"))
						&& (condos.get(i).get("price") >= condos.get(j).get("price")) ) {
					isPronunciation = false;
					break;
				}
				if( (condos.get(i).get("price") > condos.get(j).get("price"))
						&& (condos.get(i).get("distance") >= condos.get(j).get("distance")) ) {
					isPronunciation = false;
					break;
				}
			}
			
			if(isPronunciation) {
				result++;
			}
		}
		
		System.out.println(result);
	}
}
