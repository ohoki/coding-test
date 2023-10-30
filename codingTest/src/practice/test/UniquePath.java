package practice.test;

/*
 - unique path -
 이 로봇은 m * n grid(격자)위에 있습니다. 로봇은 처음에 좌측 상단 모서리 (grid[0][0])에 위치해 있습니다.
 로봇은 우측 하단 모서리(grid[m-1][n-1])로 이동하려고 합니다. 로봇은 한 번에 오른쪽이나 아래쪽으로만 움직일 수 있습니다.
 두 정수 m과 n이 주어졌을 때, 로봇이 우측 하단 모서리에 도달할 수 있는 가능한  unique paths의 수를 반환하세요.
 
 테스트 케이스는 답이 2*10^9이하가 되도록 생성됩니다.
 
 제약조건
 1<= m,n <= 100
 
*/
public class UniquePath {
	static int[][] table = null;
	
	public static void main(String[] args) {
		int m = 3;
		int n = 7;
		table = new int[m][n];
		
		System.out.println(dpBottom(m, n));
	}
	
	//bottom-up
	private static int dpBottom(int m, int n) {
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(i == 0 || j==0) {
					table[i][j] = 1; 
				} else {
					if(table[i][j] == 0) {
						table[i][j] = table[i-1][j] + table[i][j-1];
					}
				}
			}
		}
		
		return table[m-1][n-1];
	}
}
