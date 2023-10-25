package practice.test;

import java.util.HashMap;

/*
	- LongConsecutiveSequence -
	정렬되어 있지 않은 정수형 배열 nums가 주어졌다. nums 원소를 가지고 만들 수 있는 가장 긴 연속된 수의 갯수는 몇개인지 반환하시오.
	
	제약조건
	0 <= nums.length <= 10^5
	-10^9 <= nums[i] <= 10^9
*/
public class LongConsecutiveSequence {
	public static void main(String[] args) {
		int[] nums1 = {100,4,200,1,3,2};      // output : 4
		int[] nums2 = {0,3,7,2,5,8,4,6,0,1};  // output : 9
		
		System.out.println(calculateSequenceNumber(nums1));
		System.out.println(calculateSequenceNumber(nums2));
		
	} 
	
	private static int calculateSequenceNumber(int[] nums) {
		int answer = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		
		//초기화
		for(int n : nums) {
			map.put(n, n+1);
		}
		
		//찾기
		for(int i=0; i<nums.length; i++) {
			if(!map.containsKey(nums[i]-1)) {
				int cnt = 1;
				int target = nums[i];
				
				while(map.containsKey(map.get(target))) {
					cnt ++;
					target = map.get(target);
				}
				
				answer = Math.max(answer, cnt);
			}
		}
		
		return answer;
	}
}
