package practice.test;

import java.util.Stack;

/*
	- Daily Temperatures -
	매일의 온도를 나타내는 int형 배열 temperatures가 주어진다. answer배열의 원소 answer[i]는 i번 째 날의 온도보다
	더 따뜻해지기까지 며칠을 기다려야하는지 나타낸다. 만약 더 따뜻해지는 날이 없다면 answer[i] == 0 이다. 
	answer 배열을 반환하는 함수를 구현하시오.
	
	제약조건
	1 <= temperatures.length <= 10^5
	30 <= tempertaures[i] <= 100
	
*/
public class DailyTemperatures {
	public static void main(String[] args) {
		int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
		
		for(int i=0; i<temperatures.length; i++) {
			System.out.println(calculateWarmDay(temperatures)[i]);
		}
	}
	
	private static int[] calculateWarmDay(int[] temperatures) {
		int[] answer = new int[temperatures.length];
		Stack<Integer> stack = new Stack<>();
		
		for(int day=0; day<temperatures.length; day++) {
			while(!stack.empty() && temperatures[stack.peek()] < temperatures[day]) {
				int prevDay = stack.pop();
				answer[prevDay] = day - prevDay;
			}
			stack.push(day);
		}
		return answer;
	}
}
