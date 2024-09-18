package back_joon.bronze.bronze_1296;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze_1296 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String       name = br.readLine();
		int         count = Integer.parseInt(br.readLine());
		int        lCount = (int)name.chars().filter(c -> (c == 'L')).count();
		int        oCount = (int)name.chars().filter(c -> (c == 'O')).count();
		int        vCount = (int)name.chars().filter(c -> (c == 'V')).count();
		int        eCount = (int)name.chars().filter(c -> (c == 'E')).count();
		int   probability = -1;
		String     result = ""; 
		
		for(int i=0; i<count; i++) {
			String teamName = br.readLine();
			int           l = lCount + (int)teamName.chars().filter(c -> (c == 'L')).count();
			int           o = oCount + (int)teamName.chars().filter(c -> (c == 'O')).count();
			int           v = vCount + (int)teamName.chars().filter(c -> (c == 'V')).count();
			int           e = eCount + (int)teamName.chars().filter(c -> (c == 'E')).count();
				
			int teamProbability = ((l+o) * (l+v) * (l+e) * (o+v) * (o+e) * (v+e)) % 100;
			
			if( (teamProbability > probability) || (teamProbability == probability && result.compareTo(teamName) > 0) ) {
				probability = teamProbability;
				result = teamName;
			}
		}

		System.out.println(result);
	}
}
