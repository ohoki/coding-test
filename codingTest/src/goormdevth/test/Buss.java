package goormdevth.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 - 버스 추천하기 -
  현재 시간에서 가장 빨리 탈 수 있는 버스를 추천하는 기능을 구현하시오.
  다음 날의 버스를 탑승하는 경우도 고려해야 함을 유의한다.
  
  예시
  05:13
  13:60 23:54 09:31 10:57 14:16
*/

public class Buss {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String currTime = br.readLine(); //현재시간
		String[] busStopTimes = br.readLine().split(" "); //버스도착시간 배열
		int waitTime = 0; //기다려야 하는 시간
		boolean today = false; //오늘의 버스 존재 여부
		
		int currTimeToMinute = Integer.parseInt(currTime.substring(0, 2))*60 + Integer.parseInt(currTime.substring(3)); // 현재시간 -> 분으로 변환
		int[] busStopTimeToMinutes = new int[busStopTimes.length];
		
		//버스도착시간 -> 분으로 변환
		for(int i=0; i<busStopTimes.length; i++) {
			busStopTimeToMinutes[i] = Integer.parseInt(busStopTimes[i].substring(0,2))*60 + Integer.parseInt(busStopTimes[i].substring(3));
		}
		
		Arrays.sort(busStopTimeToMinutes);
		
		//기다리는 시간 찾기
		for(int t : busStopTimeToMinutes) {
			if(currTimeToMinute <= t) {
				waitTime = t - currTimeToMinute;
				today = true;
				break;
			}
		}
		
		//다음날의 버스를 탑승하는 경우
		if(!today) {
			waitTime = 24*60 - currTimeToMinute + busStopTimeToMinutes[0];
		}
		
		System.out.println(waitTime);
	}
}
