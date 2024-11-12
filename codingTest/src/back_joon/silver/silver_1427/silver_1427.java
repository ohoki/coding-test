package back_joon.silver.silver_1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class silver_1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader   br = new BufferedReader(new InputStreamReader(System.in));
		String            n = br.readLine();
		String[]    numbers = n.split("");
		String       result = Arrays.stream(numbers).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
		
		System.out.println(result);
	}
}
