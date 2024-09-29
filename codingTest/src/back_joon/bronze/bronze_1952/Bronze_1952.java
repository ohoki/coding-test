package back_joon.bronze.bronze_1952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze_1952 {
	public static void main(String[] args) throws IOException {
		BufferedReader     br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer    st = new StringTokenizer(br.readLine());
		int                 m = Integer.valueOf(st.nextToken());
	    int                 n = Integer.valueOf(st.nextToken());
		boolean[][] isVisited = new boolean[m][n];
		int[]              dx = {0, 1, 0, -1}; //오른쪽, 아래, 왼쪽, 위
		int[]              dy = {1, 0, -1, 0};
		int               sum = 0;
		int             count = 0;
		int              nowX = 0;
		int              nowY = 0;
		int               idx = 0;
		
		isVisited[nowX][nowY] = true;
		sum                   = 1;
		
		while (idx < 4) {
			int newX = nowX + dx[idx];
			int newY = nowY + dy[idx];
			
			if(sum == n*m) {
				System.out.println(count);
				break;
			}
			
			if(newX >= 0 && newX < m && newY >= 0 && newY < n && !isVisited[newX][newY]) {
				isVisited[newX][newY] = true;
				sum++;
				nowX = newX;
				nowY = newY;
			} else {
				idx++;
				count++;
			}
			
			if(idx >= 4) {
				idx = 0;
			}
		}
	}
}
