package goormdevth.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 - 케이크 먹기 -
 구름이는 케이크를 먹기로 합니다. 케이크를 n조각으로 자른 구름이는 규칙에 따라서 케이크를 먹기로 합니다. 구름이가 케이크를 먹는 규칙은 아래와 같습니다.
 	케이크는 편의를 위해서 1번 조각을 기준으로 시계방향으로 n번 조각까지 순서대로 있다고 한다.
 	구름이는 항상 1번 조각 케이크부터 먹는다.
 	다음 조각은 이전에 먹은 케이크 조각에서 시계 방향으로 남아있는 조각 들 중, k번째에 있는 조각을 먹는다.
 	케이크가 2조각 남으면, 먹는 것을 멈춘다.
 
 구름이가 케이크를 자른 조각의 개수와 k가 주어졌을 때, 마지막에 남은 케이크조각의 번호를 출력하시오.
 
 입력 6 3
 출력 3 5
*/
public class Cake {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]); //조각 수
		int k = Integer.parseInt(input[1]); //규칙 k
		CircularLinkedList nList = new CircularLinkedList(); //원형 연결 리스트
		
		for(int i=0; i<n; i++) {
			nList.add(i, i+1);
		}
		
		nList.remove(n, k);
		
		System.out.println(nList.get(0) + " " + nList.get(1));
	}
}

class CircularLinkedList {
	private Node head;
	private Node tail;
	private int size = 0;
	
	private class Node {
		private Object data;
		private Node next;
		private Node prev;
		
		public Node(Object input) {
			this.data = input;
			this.next = null;
			this.prev = null;
		}
	} 
	
	//노드 추가
	public void add(int k, Object input) {
		Node newNode = new Node(input);
		
		if(k==0) {
			newNode.next = head;
			newNode.prev = tail;
			head = newNode;
			if(size == 0) tail = newNode;
			tail.next = newNode;
			head.prev = tail;
		} else {
			Node temp1 = node(k-1);
			Node temp2 = temp1.next;
			
			temp1.next = newNode;
			newNode.next = temp2;
			newNode.prev = temp1;
			temp2.prev = newNode;
		}
		
		if(newNode.next == head) {
			tail = newNode;
		}
		
		size++;
	}
	
	//k번째 노드 삭제
	public void remove(int n, int k) {
		Node currNode = head;
		
		for(int i=0; i<n-2; i++) {
			Node temp1 = currNode.prev;
			Node temp2 = currNode.next;
			
			temp1.next = temp2;
			temp2.prev = temp1;
			
			if(currNode == head) {
				head = temp2;
				tail = temp1;
			}
			
			for(int j=0; j<k; j++) {
				currNode = currNode.next;
			}
			
			size --;
		}
	}
	
	public int size() {
		return size;
	}
	
	public Object get(int k) {
		return node(k).data;
	}
	
	private Node node(int index) {
		Node x = head;
		
		for(int i=0; i<index; i++) {
			x = x.next;
		}
		
		return x;
	}
}
