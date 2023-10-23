package practice.test;

import java.util.Arrays;

/*
 - Two sum -
 정수가 저장된 배열 nums이 주어졌을 때, nums의 원소중 두 숫자를 더해서 target이 될 수 있으면 True,
 불가능하면 False를 반환하세요. 같은 원소를 두 번 사용할 수 없습니다.
 
 제약조건
 2 <= nums.length <= 10^4
 -10^9 <= nums[i] <= 10^9
 -10^9 <= target <= 10^9
*/

/*
 시간복잡도에 관여하는 n(nums.length)가 최대 10^4이므로 O(nlogn), O(n), O(1)의 시간복잡도로 풀어야한다.
 int의 범위는 2^-31 부터 2^31+1 이므로 10^9 + 10^9는 int의 범위 안에 속한다. -> 결과값을 int로 받아도 됨 
*/
public class TwoSum {
	public static void main(String[] args) {
		int[] nums = {4,1,9,7,5,3,16};
		//int[] nums = {2,1,5,7};
		
		System.out.println(twoSum1(nums, 14));
		System.out.println(twoSum2(nums, 14));
		 
	}
	
	//1. 완전탐색 -> 시간복잡도 O(n^2) -> 시간초과 될 가능성 있음
	private static boolean twoSum1(int[] nums, int target) {
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					return true;
				}
			}
		}
		return false;
	}
	
	//2. Sort & Two Pointer -> O(nlogn) + O(n) -> O(nlogn)
	private static boolean twoSum2(int[] nums, int target) {
		int l = 0;
		int r = nums.length-1;
		
		Arrays.sort(nums); //O(nlogn)
		
		//O(n)
		while(l < r) {
			if(nums[l] + nums[r] == target) {
				return true;
			}else if(nums[l] + nums[r] < target) {
				l++;
			}else {
				r--;
			}
		}
		return false;
	}
}
