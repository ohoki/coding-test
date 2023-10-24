package practice.test.linkedList;

public class Main {
	public static void main(String[] args) {
		LinkedList numbers = new LinkedList();
		numbers.addLast(5);
		numbers.addLast(10);
		numbers.addLast(15);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.add(4, 25);
		
		System.out.println(numbers.removeFirst());
		System.out.println(numbers.remove(0));
		System.out.println(numbers.removeLast());
		System.out.println(numbers);
		System.out.println(numbers.size());
		System.out.println(numbers.get(0));
	}
}
