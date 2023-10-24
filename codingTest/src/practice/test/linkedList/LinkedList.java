package practice.test.linkedList;

public class LinkedList {
	private Node head;
	private Node tail;
	private int size = 0;
	
	private class Node {
		private Object data;
		private Node next;
		
		public Node(Object input) {
			super();
			this.data = input;
			this.next = null;
		}

		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head;
		head = newNode;
		size++;
		if(head.next == null) {
			tail = head;
		}
	}
	
	public void addLast(Object input) {
		Node newNode = new Node(input);
		if(size == 0) {
			addFirst(input);
		} else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}
	
	public void add(int k, Object input) {
		if(k == 0) {
			addFirst(input);
		} else {
			Node temp1 = node(k-1);
			Node temp2 = temp1.next;
			Node newNode = new Node(input);
			
			temp1.next = newNode;
			newNode.next = temp2;
			size++;
			
			if(newNode.next == null) {
				tail = newNode;
			}
		}
	}
	
	private Node node(int index) {
		Node x = head;
		
		for(int i=0; i<index; i++) {
			x = x.next;
		}
		
		return x;
	}
	
	public Object removeFirst() {
		Node temp = head;
		head = head.next;
		Object returnData = temp.data;
		temp = null;
		size--;
		
		return returnData;
	}
	
	public Object remove(int k) {
		if(k==0) {
			return removeFirst();
		} 
		Node temp = node(k-1);
		Node todoDeleted = temp.next;
		
		temp.next = todoDeleted.next;
		Object returnData = todoDeleted.data;
		
		if(todoDeleted == tail) {
			tail = temp;
		}
		
		todoDeleted = null;
		size--;
		
		return returnData;
	}
	
	public Object removeLast() {
		return remove(size-1);
	}
	 
	public int size() {
		return size;
	}
	
	public Object get(int k) {
		return node(k).data;
	}
	
	public String toString() {
		if(head == null) {
			return "[]";
		} 
		
		Node temp = head;
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		while(temp.next != null) {
			sb.append(temp.data).append(", ");
			temp = temp.next;
		}
		//마지막 인덱스
		sb.append(temp.data);
		sb.append("]");
		
		return sb.toString();
	}
}
