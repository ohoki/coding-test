package goormdevth.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 - 카드 관리 -
 내용 생략
 
 예시 
 0 6
 deposit 10
 pay 5
 reservation 5
 reservation 5
 pay 5
 deposit 10
 
 출력 5
*/

public class CardTranaction {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int currBalance = Integer.parseInt(input[0]); //현재 잔액
		int transCnt = Integer.parseInt(input[1]);    //거래 횟수
		ArrayList<Integer> reservations = new ArrayList<>(); //예약 내역
		
		for(int i=0; i<transCnt; i++) {
			String[] transHistory = br.readLine().split(" ");
			String transType = transHistory[0]; //거래종류
			int transBalance = Integer.parseInt(transHistory[1]); //거래금액
			
			//거래
			if(transType.equals("deposit")) {
					currBalance += transBalance;
			} else if(transType.equals("pay")) {
					if(currBalance >= transBalance) currBalance -= transBalance;
			} else if(transType.equals("reservation")) {
					if(currBalance >= transBalance && reservations.size() == 0) {
						currBalance -= transBalance;
					} else {
						reservations.add(transBalance);
					}
			}
			
			//예약내역 확인
			while(reservations.size() != 0) {
				if(currBalance >= reservations.get(0)) {
					currBalance -= reservations.remove(0);
				} else {
					break;
				}
			}
		}
		
		System.out.println(currBalance);
	}
}
