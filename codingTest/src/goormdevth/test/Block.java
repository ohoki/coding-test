package goormdevth.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 - 블록 맞추기 -
 구름이가 맞춰야 하는 퍼즐판의 크기는 가로가 N cm 세로가 M cm 크기의 퍼즐이다.
 구름이가 퍼즐을 맞추기 위해 받은 조각을 4종류이다. 각각 1x1, 2x2, 4x2, 4x4 모양이며 회전할 수 없다.
 조각들을 무한히 사용하여, 퍼즐판에 빈 곳이 없게 하고자 한다. 4종류의 퍼즐로 퍼즐판을 맞출 수 있는 경우의 수를 구하시오.
 
*/
public class Block {
	static int answer;
	static ArrayList<int[][]> blocks = new ArrayList<>();
	static int[][] block1 = {{0,0}}; // 1x1
	static int[][] block2 = {{0,0},{0,1},{1,1},{1,0}}; // 2x2
	static int[][] block3 = {{0,0},{0,1},{1,1},{1,0},{0,2},{0,3},{1,2},{1,3}}; // 4x2
	static int[][] block4 = {{0,0},{0,1},{1,1},{1,0},{0,2},{0,3},{1,2},{1,3},{2,0},{2,1},{2,2},{2,3},{3,0},{3,1},{3,2},{3,3}}; // 4x4
	static int[][] puzzleBoard = null;
	static int m;
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		puzzleBoard = new int[m][n];
		
		//블록리스트 추가
		blocks.add(block1);
		blocks.add(block2);
		blocks.add(block3);
		blocks.add(block4);
		
		answer = 0;
		cover(n * m); //dfs
		
		System.out.println(answer);
	}
	
	//dfs
	private static void cover(int cnt) { // cnt = 빈칸 갯수
		if(cnt == 0) {
			answer++;
			return;
		}
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(puzzleBoard[i][j] == 0) {
					for(int k=0; k<4; k++) {
						if(check(k, i, j)) {
							set(k, i, j, 1);
							cover(cnt - blocks.get(k).length);
							set(k, i, j, 0); //백트래킹
						}
					}
					return;
				}
			}
		}
	}
	
	//블록채우기 & 지우기
	private static void set(int k, int col, int row, int p) {
		for(int i=0; i<blocks.get(k).length; i++) {
			int nextCol = col + blocks.get(k)[i][0];
			int nextRow = row + blocks.get(k)[i][1];
			
			puzzleBoard[nextCol][nextRow] = p;
		}	
	}
	
	//블록 가능 여부
	private static boolean check(int k, int col, int row) {
		for(int i=0; i<blocks.get(k).length; i++) {
			int nextCol = col + blocks.get(k)[i][0];
			int nextRow = row + blocks.get(k)[i][1];
			
			if(!isRange(nextCol, nextRow) || puzzleBoard[nextCol][nextRow] == 1) return false;
		}
		return true;
	}
	
	//범위 아웃 여부
	private static boolean isRange(int nextCol, int nextRow) {
		if(0<= nextCol && nextCol < m && 0<= nextRow && nextRow < n) return true;
		
		return false;
	}
}
