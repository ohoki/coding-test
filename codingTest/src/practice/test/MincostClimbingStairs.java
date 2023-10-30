package practice.test;

import java.util.HashMap;

/*
 - min cost climbing stairs
 계단을 올라가고 있다. 한 번 올라갈 때마다 1step 또는 2step 올라갈 수 있다. 문제에서 정수형 배열 cost
 가 주어지는데, cost[i]는 i번 째 계단을 밟았을 때 지불해야 하는 비용이다.
 처음 시작은 index 0 또는 index 1 중 한 곳에서 시작할 수 있다.
 이 계단의 꼭대기에 도착하기 위해 지불해야 하는 비용의 최소값을 반환하라.
 
 제약조건
 2 <= cost.length <= 100
 0 <= cost[i] <= 999
*/
public class MincostClimbingStairs {
	static HashMap<Integer, Integer> memo = new HashMap<>();
	static int[] cost = {1,100,1,1,1,100,1,1,100,1}; //output : 6
	static int n = cost.length;
	
	public static void main(String[] args) {
		
		//System.out.println(dpt(n));
		System.out.println(dpb(n));
	}
	
	//top-down
	private static int dpt(int n) {
		if(n==0 || n==1) {
			return 0;
		}
		
		if(!memo.containsKey(n)) {
			memo.put(n, Math.min(dpt(n-1) + cost[n-1], dpt(n-2) + cost[n-2]));
		}
		
		return memo.get(n);
	}
	
	//bottom-up
	private static int dpb(int n) {
		for(int i=0; i<=n; i++) {
			if(i == 0 || i == 1) {
				memo.put(i, 0);
				continue;
			}
			
			if(!memo.containsKey(i)) {
				memo.put(i, Math.min(memo.get(i-1) + cost[i-1], memo.get(i-2) + cost[i-2]));
			}
		}
		
		return memo.get(n);
	}
}
