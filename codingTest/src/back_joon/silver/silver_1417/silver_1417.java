package back_joon.silver.silver_1417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class silver_1417 {
	public static void main(String[] args) throws IOException {
		BufferedReader                      br = new BufferedReader(new InputStreamReader(System.in));
		int                                  n = Integer.parseInt(br.readLine());
		int                         dasomCount = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> candidateCounts = setCandidates(br, n-1);
		
		System.out.println(getMinNumber(dasomCount, candidateCounts));
	}
	
	private static PriorityQueue<Integer> setCandidates(BufferedReader br, int n) throws IOException {
		PriorityQueue<Integer> result = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0; i<n; i++) {
			result.add(Integer.parseInt(br.readLine()));
		}
		
		return result;
	}
	
	private static int getMinNumber(int dasom, PriorityQueue<Integer> candidateCounts) {
		int result = 0;
		
		while (!candidateCounts.isEmpty() && candidateCounts.peek() >= dasom) {
			dasom++;
			candidateCounts.add(candidateCounts.poll()-1);
			result++;
		}
		
		return result;
	}
}
