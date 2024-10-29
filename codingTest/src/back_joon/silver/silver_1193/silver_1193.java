package back_joon.silver.silver_1193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class silver_1193 {
	public static void main(String[] args) throws IOException {
		BufferedReader   br = new BufferedReader(new InputStreamReader(System.in));
		int               x = Integer.valueOf(br.readLine());
		int        layerSum = 0;
		int           layer = 0;
		StringBuffer result = new StringBuffer(); 
		
		while(layerSum < x) {
			layer++;
			layerSum += layer;
		}
		
		int backIndex = layerSum - x;
	
		if(layer%2 == 0) {
			result.append(String.valueOf(layer-backIndex) + "/" + String.valueOf(1+backIndex));
		} else {
			result.append(String.valueOf(1+backIndex) + "/" + String.valueOf(layer-backIndex));
		}
		
		System.out.println(result);
	}	
}
