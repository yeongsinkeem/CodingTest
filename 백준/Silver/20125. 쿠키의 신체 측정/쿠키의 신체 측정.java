import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int mapSize = Integer.parseInt(br.readLine());
		char [][]map = new char[mapSize + 1][mapSize + 1];
		
		// 1. 보드판 만들기
		for(int i = 1; i <= mapSize; i++) {
			String line = br.readLine();
			for(int j = 1; j <= mapSize; j++) {
				map[i][j] = line.charAt(j - 1);
			}
		}
		
		// 2. 심장 위치 구하기 
		boolean flag = false;
		int[] heart = new int[2];
		for(int i = 1; i <= mapSize; i++) {
			if( !flag ) {
				for(int j = 1; j <= mapSize; j++) {
					if(map[i][j] == '*') {
						heart[0] = i + 1;
						heart[1] = j;
						flag = true;
					}
				}
			}
		}
		
		// 3. 팔/허리/다리 길이 구하기 
		int x = heart[0];
		int y = heart[1];
		int[] body = new int[5];
		
		for(int i = 1; i <= mapSize; i++) {
			// 3-1. 팔 
			// x는 동일하고, y는 작거나 커야. 이때 x좌표는 계속 동일 
			for(int j = 1; j <= mapSize; j++) {
				if( i == x && j < y && map[i][j] == '*' ) { 
					body[0] = body[0] + 1;
				}
				else if( i == x && j > y && map[i][j] == '*' ) {
					body[1] = body[1] + 1;
				}
			}
			
			// 3-2. 허리 
			// x는 커야하고, y는 동일 
			for(int j = 1; j <= mapSize; j++) {
				if( i > x && j == y && map[i][j] == '*') {
					body[2] = body[2] + 1;
				}
			}
			
			// 3-3. 다리 
			for(int j = 1; j <= mapSize; j++) {
				// x는 커야하고, y는 작거나 커야 함. 이때 y 좌표는 계속 동일 
				if( i > x && j < y && map[i][j] == '*' ) {
					body[3] = body[3] + 1;
				}
				else if( i > x && j > y && map[i][j] == '*') {
					body[4] = body[4] + 1;
				}
			}
		}
		
		System.out.println(heart[0] + " " + heart[1]);
		System.out.println(body[0] + " " + body[1] + " " + body[2] + " " + body[3] + " " + body[4]);
	}
}