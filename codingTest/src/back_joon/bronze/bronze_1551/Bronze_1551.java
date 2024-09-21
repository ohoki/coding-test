package back_joon.bronze.bronze_1551;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Bronze_1551 {
	public static void main(String[] args) throws IOException {
		BufferedReader        br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer       st = new StringTokenizer(br.readLine());
		int                    n = Integer.parseInt(st.nextToken());
		int                    k = Integer.parseInt(st.nextToken());
		int[]            numbers = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray(); 
		List<Integer> numberList = Arrays.stream(numbers).boxed().collect(Collectors.toList());
		StringBuffer      result = new StringBuffer();
		
		for(int i=0; i<k; i++) {
			for(int j=0; j<numberList.size()-1; j++) {
				numberList.set(j, numberList.get(j+1) - numberList.get(j));
			}
			numberList.remove(numberList.size()-1);
		}
		
		for(int i=0; i<numberList.size(); i++) {
			if(i == 0) {
				result.append(numberList.get(i));
			} else {
				result.append("," + numberList.get(i));
			}
		}
		
		System.out.println(result);
	}
}
