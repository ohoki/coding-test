package back_joon.bronze.bronze_5597;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Bronze_5597 {
	public static void main(String[] args) throws IOException {
		BufferedReader   br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> students = new HashSet<Integer>();
		
		for(int i=0; i<28; i++) {
			students.add(Integer.parseInt(br.readLine()));
		}
		
		for(int i=1; i<=30; i++) {
			if(!students.contains(i)) {
				System.out.println(i);
			}
		}
	}
}
