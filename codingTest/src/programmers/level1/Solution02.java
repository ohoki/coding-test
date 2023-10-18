package programmers.level1;

import java.util.Arrays;

/*
	- 정수 내림차순으로 정렬하기 -
	함수 solution은 정수 n을 매개변수로 입력받습니다. 
	n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 
	예를들어 n이 118372면 873211을 리턴하면 됩니다.
*/

public class Solution02 {
	public static void main(String[] args) {
		long n = 118372;
		long answer = 0;
//		String answerStr = "";
//		
//		String nStr = String.valueOf(n);
//		Character[] nStrArr = new Character[nStr.length()];
//		
//		for(int i=0; i<nStrArr.length; i++) {
//			nStrArr[i] = nStr.charAt(i);
//		}
//		
//		Arrays.sort(nStrArr, Collections.reverseOrder());
//		
//		for(Character c : nStrArr) {
//			answerStr += c;
//		}
//		
//		answer = Long.parseLong(answerStr);
		
		String[] list = String.valueOf(n).split("");
		Arrays.sort(list);
		
		StringBuilder sb = new StringBuilder();
		
		for(String item : list) {
			sb.append(item);
		}
		
		answer = Long.parseLong(sb.reverse().toString());
	}
}