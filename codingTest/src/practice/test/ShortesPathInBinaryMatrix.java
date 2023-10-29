package practice.test;

import java.util.LinkedList;
import java.util.Queue;

/*
 - shortest path in binary matrix
 
  n * n binary matrix인 grid가 주어졌을 때, 출발지에서 목적지 까지 도착하는 가장 빠른 경로의 길이를 반환하시오.
  만약 경로가 없다면 -1을 반환하시오.
  
  출발지 : top-left cell
  목적지 : bottom -right cell
  
  값이 0인 cell만 지나갈 수 있다.
  cell끼리는 8가지 방향으로 연결되어 있다.
  연결된 cell을 통해서만 지나갈 수 있다.
  
  제약 조건
  n == grid.length
  n == grid[i].length
  1 <= n <= 100
  grid[i][i] is 0 or 1
  
*/
public class ShortesPathInBinaryMatrix {
	public static void main(String[] args) {
		int[][] grid = {{0,0,0},
						{1,1,0},
						{1,1,0}};
		
		System.out.println(	bfs(grid));
	}
	
	public static int bfs(int[][] grid) {
		int colLength = grid.length;
		int rowLength = colLength;
		int shortesPath = -1;
		
		if(grid[0][0] != 0 || grid[colLength-1][rowLength-1] != 0) {
			return shortesPath;
		}
		
		boolean[][] visited = new boolean[colLength][rowLength];
		Queue<int[]> q = new LinkedList<>();
		int[][] dir = {{-1,0},{1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
		
		visited[0][0] = true;
		q.offer(new int[]{0,0,1});
		
		while(!q.isEmpty()) {
			int[] currPos = q.poll();
			int currCol = currPos[0];
			int currRow = currPos[1];
			int currPath = currPos[2];
			
			if(currCol == colLength-1 && currRow == rowLength-1) {
				shortesPath = currPath;
				return shortesPath;
			}
			
			for(int[] d : dir) {
				int nextCol = currCol + d[0];
				int nextRow = currRow + d[1];
				
				if(isRange(nextCol, nextRow, colLength, rowLength)) {
					if(grid[nextCol][nextRow] == 0 && visited[nextCol][nextRow] == false) {
						visited[nextCol][nextRow] = true;
						q.offer(new int[] {nextCol, nextRow, currPath +1});
					}
				}
			}
		}
		return shortesPath;
	}
	
	public static boolean isRange(int c, int r, int cLength, int rLength) {
		if(0 <= c && c < cLength && 0 <= r && r < rLength) return true;
		
		return false;
	}
}

