package back_joon.silver.silver_1094;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class silver_1094 {
	public static void main(String[] args) throws IOException {
		BufferedReader   br = new BufferedReader(new InputStreamReader(System.in));
		int               x = Integer.valueOf(br.readLine()); //23
		int           stick = 64;
		int     totalLength = stick;
		int            temp = totalLength;
		int       sumLength = 0;
		int           count = 0;
		
		while(sumLength <= x){
			if(x == 64) {
				System.out.println(++count);
				break;
			} else if(sumLength == x) {
				System.out.println(count);
				break;
			}

			stick /= 2;
			temp   = totalLength -stick;
			
			if(temp > x) {
				totalLength = temp;
			} else {
				sumLength += stick;
				count++;
			}
		}
	}
}
