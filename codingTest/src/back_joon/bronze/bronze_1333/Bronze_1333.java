package back_joon.bronze.bronze_1333;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Bronze_1333 {
	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		String[]   numbers = br.readLine().split(" ");
		List<Boolean> isOk = new ArrayList<Boolean>();
		int              n = Integer.parseInt(numbers[0]);
		int              l = Integer.parseInt(numbers[1]);
		int              d = Integer.parseInt(numbers[2]);
		int          count = 1;
		int         result = d;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<l; j++) {
				isOk.add(false);
			}
			if(i != n-1) {
				for(int k=0; k<5; k++) {
					isOk.add(true);
				}
			}
		}
		
		while(result < isOk.size()) {
			if(isOk.get(result) == true) {
				break;
			} else {
				count++;
				result = d * count;
			}
		}
		
		System.out.println(result);
	}
}
