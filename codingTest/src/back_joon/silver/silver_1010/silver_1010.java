package back_joon.silver.silver_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class silver_1010 {
	private static int[][] dp = new int[30][30];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int             t = Integer.parseInt(br.readLine());
		StringBuilder  sb = new StringBuilder();
		
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int              n = Integer.parseInt(st.nextToken());
			int              m = Integer.parseInt(st.nextToken());

			sb.append(combination(m, n)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	private static int combination(int m, int n) {
		if(dp[m][n] > 0) {
			return dp[m][n];
		} else if(m == n || n == 0) {
			return dp[m][n] = 1;
		} else {
			return dp[m][n] = combination(m-1, n-1) + combination(m-1, n);
		}
	}
}
