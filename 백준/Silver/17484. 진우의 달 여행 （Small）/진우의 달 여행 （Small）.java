import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// 17 : 18 ~ 
		// DP -> 중복 + 이전 상태와 같이 제약 조건 존재 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		int[][][] dp = new int[N][M][3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1. DP 배열 초기화 -> 첫번째 행 
		for(int j = 0; j < M; j++) {
			dp[0][j][0] = arr[0][j];
			dp[0][j][1] = arr[0][j];
			dp[0][j][2] = arr[0][j];
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < M; j++) {
				for(int k = 0; k < 3; k++) {
					dp[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}
		
		// 2. DP 테이블 채우기 : 2번째 행부터 
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < M; j++) {
				// 현재 칸 (i, j)로 올 수 있는 3가지 방향 계산 
				// 왼쪽에서 내려오는 경우 ) 이전 칸 : i-1, j-1 
				if( j - 1 >= 0 ) {
					dp[i][j][0] = arr[i][j] + Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]);
				}
				
				// 바로 위칸에서 내려오는 경우 ) 이전 칸 : i-1, j 
				dp[i][j][1] = arr[i][j] + Math.min(dp[i-1][j][0], dp[i-1][j][2]);
				
				// 오른쪽에서 내려오는 경우 ) 이전 칸 : i-1, j+1
				if( j + 1 < M ) {
					dp[i][j][2] = arr[i][j] + Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]);
				}
			}
		}
		
		int minSum = Integer.MAX_VALUE;
		for(int j = 0; j < M; j++) {
			for(int k = 0; k < 3; k++) {
				minSum = Math.min(minSum,  dp[N-1][j][k]);
			}
		}
		
		System.out.println(minSum);
	}
}