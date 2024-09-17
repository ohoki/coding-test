package back_joon.bronze.bronze_1236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze_1236 {
	public static void main(String[] args) throws IOException {
		BufferedReader   br = new BufferedReader(new InputStreamReader(System.in));
		String[]    numbers = br.readLine().split(" ");
		int          rowNum = Integer.parseInt(numbers[0]);
		int       columnNum = Integer.parseInt(numbers[1]);
		String[][]   castle = new String[rowNum][columnNum];
		int       rowManNum = 0;
		int columnManNumber = 0;
		
		for(int i=0; i<castle.length; i++) {
			String[] row = br.readLine().split("");
			castle[i] = row;
		}
		
		for(int i=0; i<rowNum; i++) {
			for(int j=0; j<columnNum; j++) {
				if("X".equals(castle[i][j])) {
					break;
				} else if(j == columnNum -1) {
					rowManNum++;
				}
			}
		}
		
		for(int i=0; i<columnNum; i++) {
			for(int j=0; j<rowNum; j++) {
				if("X".equals(castle[j][i])) {
					break;
				} else if(j == rowNum -1) {
					columnManNumber++;
				}
			}
		}
		
		int result = rowManNum >= columnManNumber ? rowManNum : columnManNumber;
		
		System.out.println(result);
	}
}
