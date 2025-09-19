import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] paper = new int[10][10];
	static int result = Integer.MAX_VALUE;
	// static int useCnt;
	static int[] S = {0, 5, 5, 5, 5, 5};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 1. 색종이 판 만들기 -> 탐색 공간 생성 
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		backTracking(0, 0);
		if( result == Integer.MAX_VALUE ) {
			result = -1;
		}
		System.out.println(result);
		
	}
	
	// xy: 좌표, useCnt: 총 몇 장 썼는지 
	private static void backTracking(int xy, int useCnt) {
		// 1. 종료 : 탐색 완료 
		if( xy == 100 ) {
			result = Math.min(result, useCnt);
			return; 
		}
		int x = xy % 10;
		int y = xy / 10;
		// 2. 가지치기 
		// 2-1. 다 덮기 위해 사용한 색종이의 . . ?
		if( result <= useCnt ) return; 
		
		// 2-2. 색종이 붙일 수 있고 
		if( paper[x][y] == 1 ) {
			// 최대한 큰 색종이 붙이면서 이동 
			for(int i = 5; i > 0; i--) {
				// 색종이 개수가 충분하고, 크기에 맞게 딱 붙일 수 있는지 
				if(S[i] > 0 && check(x, y, i)) {
					S[i]--; 
					fill(x, y, i, 0);
					backTracking(xy+1, useCnt+1); // 한칸씩만 가도 문제 없음. 왜 ? 좌표처리 해주기 때문 
					S[i]++;
					fill(x, y, i, 1);
				}
			}
		} else {
			backTracking(xy+1, useCnt);
		}
	}
	
	// 좌표 처리 
	private static void fill(int x, int y, int size, int val) {
		for(int i = x; i < x+size; i++) {
			for(int j = y; j < y+size; j++) {
				paper[i][j] = val;
			}
		}
	}

	// 색종이 딱 맞게 붙일 수 있는지 
	private static boolean check(int x, int y, int size) {
		if(x + size > 10 || y + size > 10) return false;
		
		for(int i = x; i < x+size; i++) {
			for(int j = y; j < y+size; j++) {
				if (paper[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}