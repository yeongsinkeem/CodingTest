

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] A;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
        A = new int[N];
		cnt = 0;
        
		backTracking(0);
		System.out.println(cnt);
	}
	
	public static void backTracking(int start) {
		// 1. 종료조건 
		if(start == N) {
			cnt++;
			return;
		}
		
		// 2. 탐색 + 가지치기 
		for(int i = 0; i < N; i++) {
			A[start] = i;
			if(attack(start)) {
				backTracking(start + 1);
			}
		}
	}

	public static boolean attack(int a) {
		for(int i = 0; i < a; i++) {
			if(A[a] == A[i]) return false;
			if(Math.abs(A[a] - A[i]) == Math.abs(a - i)) return false;
		}
		return true;
	}
}