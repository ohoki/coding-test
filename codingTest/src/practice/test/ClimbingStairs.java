package practice.test;

/*
 - climbing stairs
 계단을 올라가고 있다. 이 계단의 꼭대기에 도착하려면 n개의 steps만큼 올라가야 한다.
 한 번 올라갈 때 마다 1step 또는 2step 올라갈 수 있다. 꼭대기에 도달하는 방법의 개수는 총 몇 가지 일까요?
 
 제약조건
 1 <= n <= 45
*/
public class ClimbingStairs {
	public static void main(String[] args) {
		int n = 10;
		
		System.out.println(cs(n));
	}
	
	public static int cs(int n) {
		int[] table = new int[n+1];
		table[1] = 1;
		table[2] = 2;
		
		for(int i=3; i<table.length; i++) {
			table[i] = table[i-1] + table[i-2];
		}
		
		return table[n];
	}
	
}
