package goormdevth.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

/*
 - 물탱크 설치하기
 총 n개의 가구와 b-1개의 단방향 수로가 설치되어 있다. 물탱크의 설치 위치를 찾으시오.
 모든 수로는 한쪽 방향으로만 이동한다.
 물이 들어오는 수로는 1 개만 설치할 수 있다.
 항상 물탱크가 설치 될 수 있는 가구의 위치는 1곳이다.
 
 예시
 6
 1 2
 1 3
 1 4
 4 5
 4 6
 
 출력
 1
*/

public class WaterTank {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashSet<Integer> receiveHouses = new HashSet<>(); // 물이 들어가는 가구
		
		// 물이 들어가는 가구 set에 초기화
		for(int i=1; i<n; i++) {
			String input = br.readLine();
			int receiveHouse = Integer.parseInt(input.substring(input.indexOf(" ")+1));
			
			receiveHouses.add(receiveHouse);
		}
		
		int giveHouse = 0; //물탱크를 설치한 가구
		
		// set에 없는 가구 -> 물탱크를 설치한 가구
		for(int i=1; i<=n; i++) {
			if(!receiveHouses.contains(i)) {
				giveHouse = i;
			}
		}
		
		System.out.println(giveHouse);
	}
}
