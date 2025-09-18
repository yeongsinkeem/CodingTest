import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] S;
	static boolean[] V;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		S = new int[N];
		V = new boolean[N];
		
		backTracking(0);
	}

	private static void backTracking(int length) {
		// 1. 종료 조건 
		if( length == M ) {
			printArray();
			return;
		}
		// 2. 백트래킹 
		for(int i = 0; i < N; i++) {
			if( !V[i] ) { // 가지치기 )미방문 경로만 
				V[i] = true;
				S[length] = i;
				backTracking(length + 1);
				V[i] = false;
			}
		}
	}

	private static void printArray() {
		for(int i = 0; i < M; i++) {
			System.out.print(S[i] + 1 + " ");
		}
	}
}