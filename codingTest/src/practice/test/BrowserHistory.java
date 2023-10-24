package practice.test;

import java.util.LinkedList;

/*
 - Design Browser History -
 인터넷 브라우저에서 방문기록과 동일한 작동을 하는 BrowserHistory class를 구현한 것이다. 구현할 브라우저는 hompage에서 시작하고, 이후에는 다른 url에 방문할 수 있다.
 또, "뒤로가기"와 "앞으로 가기"가 작동하도록 구현하라.
 
 - BrowserHistory(string hompage)를 호출하면 브라우저는 hompage에서 시작이 된다.
 - void visit(string url)을 호출하면 현재 page의 앞에 있는 페이지기록은 다 삭제가 되고 url로 방문을 한다.
 - string back(int steps)을 호출하면 steps수 만큼 "뒤로 가기"를 한다. "뒤로 가기"를 할 수 있는 page 개수가 x 이고 step > x 라면 x번 만큼만 "뒤로 가기를 한다.
   "뒤로 가기"가 완료되면 현재 url을 return한다.
 - string forward(int steps)을 호출하면 steps수 만큼 "앞으로 가기"를 할 수 있는 page 개수가 x 이고 step > x 라면 x번 만큼만 "앞으로 가기"를 한다.
   "앞으로 가기"가 완료되면 현재 url을 return 한다.
   
 제약 조건
 1 <= hompage.length <= 20
 1 <= url.length <= 20
 1 <= step <= 100
 hompage와 url은 '.'를 포함한 lower case 영어 문자로 구성되어 있다.
 visit, back 그리고 forward는 최대 5000번의 호출이 있을 수 있다.
 
*/
public class BrowserHistory {
	private LinkedList<String> linkedList = new LinkedList<>();
	int idx = 0;
	
	public BrowserHistory(String homepage) {
		linkedList.add(homepage);
    }
    
	public void visit(String url) {
        idx++;
        linkedList.add(idx, url);
        while(idx < linkedList.size()-1) {
        	linkedList.removeLast();
        }
    }
    
    public String back(int steps) {
    	if(idx - steps < 0) {
    		idx = 0;
    	} else {
    		idx -= steps;
    	}
    	
    	return linkedList.get(idx);
    }
    
    public String forward(int steps) {
        if(idx + steps >= linkedList.size()) {
        	idx = linkedList.size() -1;
        } else {
        	idx += steps;
        }
        
        return linkedList.get(idx);
    }
    
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("[");
    	
    	for(int i=0; i<linkedList.size()-1; i++) {
    		sb.append(linkedList.get(i)).append(", ");
    	}
    	
    	sb.append(linkedList.get(linkedList.size()-1));
    	sb.append("]");
    	
    	return sb.toString();
    }
    
    public static void main(String[] args) {
		BrowserHistory bh = new BrowserHistory("naver.com");
		bh.visit("google.com");
		bh.visit("facebook.com");
		bh.visit("youtube.com");
		System.out.println(bh);
		System.out.println(bh.back(1));
		System.out.println(bh.back(1));
		System.out.println(bh.forward(1));
		bh.visit("linkedin.com");
		System.out.println(bh.forward(2));
		System.out.println(bh.back(2));
		System.out.println(bh.back(7));
		System.out.println(bh);
	}
}
