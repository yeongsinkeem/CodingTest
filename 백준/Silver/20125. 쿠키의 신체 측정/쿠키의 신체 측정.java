import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 심장 위치 : 머리 바로 아래 
		// ( 팔, 다리, 허리 ) 길이  
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[][] map = new char[N][N];
		
		// 1. 쿠키 표시
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				char c = s.charAt(j);
				map[i][j] = c;
			}
		}
		
		// 2. 위치 측정
		// 2 - 1. 심장
		int[] heart = new int[2];
		boolean flag = false;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if( map[i][j] == '*' ) {
					heart[0] = i + 2;
					heart[1] = j + 1;
					flag = true;
					break;
				}
			}
			if( flag ) break;
		}
		
		// 2 - 2. 팔 
		// 왼팔 : 0 ~ 심장 전 
		// 오른팔 : 심장 후 ~ 끝 
		// row는 심장 - 1이랑 동일 
		int row = heart[0] - 1;
		int leftHand = 0;
		int rightHand = 0;
		
		for(int i = 0; i < heart[1] - 1; i++) {
			if( map[row][i] == '*' ) {
				leftHand++;
			}
		}
		for(int i = heart[1]; i < N; i++) {
			if( map[row][i] == '*' ) {
				rightHand++;
			}
		}
		
		// 2 - 3. 허리 
		// col은 heart[1]과 같되, row는 달라야 
		// row : heart[0] ~ 허리까지 
		int waist = 0;
		
		for(int i = heart[0]; i < N; i++) {
			if( map[i][ heart[1] - 1 ] == '*' ) waist++;
		}
		
		// 2 - 4. 다리
		// row는 허리 + 1 ~ 끝 
		int col = heart[0] + waist;
		int leftLeg = 0;
		int rightLeg = 0;
		
		for(int i = col; i < N; i++) {
			if( map[i][heart[1] - 2] == '*' ) {
				leftLeg++;
			}
		}
		for(int i = col; i < N; i++) {
			if( map[i][heart[1]] == '*' ) {
				rightLeg++;
			}
		}
		
		System.out.println(heart[0] + " " + heart[1]);
		System.out.println(leftHand + " " + rightHand + " " + waist + " " + leftLeg + " " + rightLeg);
		
	}
}