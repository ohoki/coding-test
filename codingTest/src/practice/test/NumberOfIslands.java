package practice.test;

import java.util.LinkedList;
import java.util.Queue;

/*
 - Number of Islands -
 grid는 "1"(land)과 "0"(water)으로 이루어진 지도를 표현하는 m * n 이차원배열이다. 이 지도에 표시된 섬들의 총 갯수를 반환하시오.
 섬이란 수평과 수직으로 땅이 연결되어 있고 주변은 물로 둘러쌓여있는 것을 말한다. 또한, grid의 네개의 가장자리는 모두 물로 둘러쌓여있다고 가정하고 문제를 해결하라.
 
 제약조건
 m == grid.length
 n == gird[i].length
 l <= m, n <= 300
 grid[i][j] is '0' or '1'
*/

public class NumberOfIslands {
	static int[][] grid = {{1,1,1,1,0},
						   {1,1,0,1,0},
						   {1,1,0,0,1},
						   {0,0,1,1,0}};
	static int col = grid.length;
	static int row = grid[0].length;
	static Queue<int[]> q = new LinkedList<>();
	
	static boolean[][] visited = new boolean[col][row];
	
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,1,-1};
	
	public static void main(String[] args) {
		int numberOfIlands = 0;
		
//		for(int i=0; i<col; i++) {
//			for(int j=0; j<row; j++) {
//				if(grid[i][j] == 1 && visited[i][j] == false) {
//					bfs(i,j);
//					numberOfIlands++;
//				}
//			}
//		}
		
		for(int i=0; i<col; i++) {
			for(int j=0; j<row; j++) {
				if(grid[i][j] == 1 && visited[i][j] == false) {
					dfs(i,j);
					numberOfIlands++;
				}
			}
		}
		
		System.out.println(numberOfIlands);
	}
	
	public static void bfs(int i,  int j) {
		visited[i][j] = true;
		int[] coor = {i, j};
		q.add(coor);
		
		while(!q.isEmpty()) {
			int curCol = q.peek()[0];
			int curRow = q.poll()[1];
			for(int k=0; k<4; k++) {
				int nextCol = curCol + dy[k];
				int nextRow = curRow + dx[k];
				
				if(0<= nextCol && nextCol < col && 0<= nextRow && nextRow < row) {
					if(visited[nextCol][nextRow] == false && grid[nextCol][nextRow] == 1) {
						visited[nextCol][nextRow] = true;
						int[] temp = {nextCol, nextRow};
						q.add(temp);
					}
				}
			}
		}
	}
	
	public static void dfs(int i, int j) {
		visited[i][j] = true;
		
		for(int k=0; k<4; k++) {
			int nextCol = i + dy[k];
			int nextRow = j + dx[k];
			
			if(0<= nextCol && nextCol < col && 0<= nextRow && nextRow < row) {
				if(visited[nextCol][nextRow] == false && grid[nextCol][nextRow] == 1) {
					visited[nextCol][nextRow] = true;
					dfs(nextCol, nextRow);
				}
			}
		}
	}
}
