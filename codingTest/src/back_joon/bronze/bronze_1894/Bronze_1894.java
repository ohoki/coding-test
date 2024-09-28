package back_joon.bronze.bronze_1894;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Bronze_1894 {
	public static void main(String[] args) throws IOException {
		BufferedReader   br = new BufferedReader(new InputStreamReader(System.in));
		String coordinate = null;
		
		while ((coordinate = br.readLine()) != null) {
			String[] points = sortCoordinate(coordinate.split(" "));
			
			BigDecimal         x1 = new BigDecimal(points[0]);
			BigDecimal         y1 = new BigDecimal(points[1]);
			BigDecimal         x2 = new BigDecimal(points[2]);
			BigDecimal         y2 = new BigDecimal(points[3]);
			BigDecimal meetPointX = new BigDecimal(points[4]);
			BigDecimal meetPointY = new BigDecimal(points[5]);
			BigDecimal    xVector = meetPointX.subtract(x1);
			BigDecimal    yVector = meetPointY.subtract(y1);
			BigDecimal         x5 = x2.subtract(xVector);
			BigDecimal         y5 = y2.subtract(yVector);
					
			System.out.println(x5 + " " + y5);
		}
	}
	
	public static String[] sortCoordinate(String[] coordinate) {
		String[] sortedCoordinate = new String[6];
		int                     k = 0;
		
		loop1:
		for(int i=0; i<=2; i+=2) {
			for(int j=4; j<=6; j+=2) {
				if(coordinate[i].equals(coordinate[j]) && coordinate[i+1].equals(coordinate[j+1])) {
					sortedCoordinate[4] = coordinate[i];
					sortedCoordinate[5] = coordinate[i+1];
					coordinate[i]   = null;
					coordinate[i+1] = null;
					coordinate[j]   = null;
					coordinate[j+1] = null;
					break loop1;
				} 
			}
		}

		for(int i=0; i<coordinate.length; i+=2) {
			if(coordinate[i] != null) {
				sortedCoordinate[k]   = coordinate[i];
				sortedCoordinate[k+1] = coordinate[i+1];
				k += 2;
			}
		}

		return sortedCoordinate;
	}
}
