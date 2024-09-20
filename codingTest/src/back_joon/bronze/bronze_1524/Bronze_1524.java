package back_joon.bronze.bronze_1524;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Bronze_1524 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int    testNumber = Integer.parseInt(br.readLine());
		
		for(int i=0; i<testNumber; i++) {
			String      emptyLine = br.readLine();
			StringTokenizer    st = new StringTokenizer(br.readLine());
			int                 n = Integer.parseInt(st.nextToken());
			int                 m = Integer.parseInt(st.nextToken());
			List<Integer> nPowers = new ArrayList<Integer>();
			List<Integer> mPowers = new ArrayList<Integer>();
			
			for(String power : br.readLine().split(" ")) {
				nPowers.add(Integer.parseInt(power));
			}
			for(String power : br.readLine().split(" ")) {
				mPowers.add(Integer.parseInt(power));
			}
			
			Collections.sort(nPowers);
			Collections.sort(mPowers);
			
			while (nPowers.size() > 0 && mPowers.size() > 0) {
				if(nPowers.get(0) > mPowers.get(0)) {
					mPowers.remove(0);
				} else if(nPowers.get(0) < mPowers.get(0)) {
					nPowers.remove(0);
				} else {
					mPowers.remove(0);
				}	
			}
			
			if(nPowers.size() > 0 && mPowers.size() > 0) {
				System.out.println("C");
			} else if(nPowers.size() > 0) {
				System.out.println("S");
			} else if(mPowers.size() > 0) {
				System.out.println("B");
			}
		}
	}
}
