package goormdevth.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 - 구슬 게임 -
 가위바위보에서 승리하면 1개를 가져오고, 패배하면 1 개를 빼앗기고, 무승부는 교환하지 않는다.
 둘 중 한명이 모든 구슬을 잃을 수 있는 경우의 수를 구하여라.
 아무도 구슬을 모두 잃을 수 없다면 0을 출력하라.
*/
public class MarbleGame {
static int count = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]); //구름이 구슬
		int m = Integer.parseInt(input[1]); //상대방 구슬
		int k = Integer.parseInt(input[2]); //게임 제한 횟수
		
		dfs(n, m, k);
		
		System.out.println(count);
	}
	
	public static void dfs(int n, int m, int k) {
		if(n == 0 || m == 0) {
			count++;
			return;
		}
		
		if(k == 0) {
			return;
		}
		
		k--;
		
		dfs(n+1, m-1, k); //승
		dfs(n-1, m+1, k); //패
		dfs(n, m, k);     //무
	}
}
