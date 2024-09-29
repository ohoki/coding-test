package back_joon.bronze.bronze_2163;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze_1952 {
	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int              n = Integer.valueOf(st.nextToken());
		int              m = Integer.valueOf(st.nextToken());
		
		System.out.println((n-1) + (n * (m-1)));
	}
}
