package back_joon.silver.silver_1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class silver_1475 {
	public static void main(String[] args) throws IOException {
		BufferedReader         br = new BufferedReader(new InputStreamReader(System.in));
		int                     n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = setRemainderQueue(n);
		
		System.out.println(calculateCardSetCount(pq));
	}
	
	private static PriorityQueue<Integer> setRemainderQueue(int n) {
		PriorityQueue<Integer> result = new PriorityQueue<>();
		
		while(n != 0) {
			result.add(n%10);
			n = n/10;
		}
		
		return result;
	}
	
	private static int calculateCardSetCount(PriorityQueue<Integer> pq) {
		if(pq.isEmpty()) {
			return 0;
		}
		
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		int                   maxCount = 0;
		
		while(!pq.isEmpty()) {
			int currentNumber = pq.poll();
			int         count = countMap.getOrDefault(currentNumber, 0) + 1;
			
			countMap.put(currentNumber, count);
			
			if(currentNumber != 6 && currentNumber != 9) {
				maxCount = Math.max(maxCount, count);
			}
		}
		
		int sixNineCount = (int)(Math.ceil((countMap.getOrDefault(6, 0) + countMap.getOrDefault(9, 0))/2.0));
		
		return Math.max(maxCount, sixNineCount);
	}
}
