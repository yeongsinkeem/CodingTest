
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] answer = new int[N];
		
		// 1. 점화식 
		int[][] dp = new int[10001][4];
		dp[0][1] = 1;
		dp[0][2] = 0;
		dp[0][3] = 0;
		
		for(int i = 1; i <= 10000; i++) {
			if( i - 1 >= 0 ) dp[i][1] = dp[i-1][1];
			if( i - 2 >= 0 ) dp[i][2] = dp[i-2][1] + dp[i-2][2];
			if( i - 3 >= 0 ) dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
		}
		
		// 2. 숫자 입력받기 
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			answer[i] = dp[num][1] + dp[num][2] + dp[num][3];
		}
		
		for(int i : answer) {
			System.out.println(i);
		}
		
	}
}