import java.util.Scanner;

public class Main {
	private static int N;
	private static int[] A;
	private static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cnt = 0;
		
		A = new int[N];
		
		backTracking(0);
		System.out.println(cnt);
	}
	
	public static void backTracking(int row) {
		// 1. 종료 조건
		// 마지막 행까지 검사해야 하기 때문에 row == N-1이 아님 
		if(row == N) {
			cnt++;
			return;
		}
		
		// 2. 가능한 모든 경우 탐색 
		for(int i = 0; i < N; i++) {
			A[row] = i;
			// 2-1. 공격이 가능하다면 
			if(check(row)) {
				// 다음 행에 퀸을 배치하러 가야 함.
				backTracking(row+1);
			}
		}
	}
	
	public static boolean check(int row) {
		// 이전 행들에만 퀸이 놓여있음 
		for(int i = 0; i < row; i++) {
			// 직선 공격 
			if(A[row] == A[i]) return false;
			// 대각선 공격 
			if( Math.abs(row - i) == Math.abs(A[row] - A[i])) return false;
		}
		return true;
	}
}