package back_joon.silver.silver_1312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class silver_1312 {
	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int          child = Integer.parseInt(st.nextToken());
		int         parent = Integer.parseInt(st.nextToken());
		int              n = Integer.parseInt(st.nextToken()); 
		int         result = 0;
		
		for(int i=0; i<n; i++) {
			child = (child % parent) * 10;
			
			result = child / parent;
		}
		
		System.out.println(result);
	}
}