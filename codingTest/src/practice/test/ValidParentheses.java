package practice.test;

import java.util.Stack;

/*
	- 괄호 유효성 체크 -
	'() {} []'를 포함하고 있는 문자열 s 가 주어졌을 때, 괄호가 유효한지 아닌지 판별하시오.
	
	제약조건
	1 <= s.length <= 10^4
	문자열 s는 '(){}[]'의 괄호 들로만 구성되어 있다.
*/

public class ValidParentheses {
	public static void main(String[] args) {
		String s = "{()[]";
		
		System.out.println(validBracket(s));
	}
	
	private static boolean validBracket(String s) {
		Stack<Character> stack = new Stack<>();
		
		for(char c : s.toCharArray()) {
			if(c == '{') {
				stack.push('}');
			} else if(c == '(') {
				stack.push(')');
			} else if(c == '[') {
				stack.push(']');
			} else if(!stack.empty() && stack.peek() == c) {
				stack.pop();
			} else {
				return false;
			}
		}
		return stack.empty(); //비어있다면 true 아니면 false
	}
}
