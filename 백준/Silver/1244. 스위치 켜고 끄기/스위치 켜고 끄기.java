import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] switches;
	static int N = 0;
	
	public static void main(String[] args) throws IOException {
		// 16 : 10 ~ 
		
		// 1. 배열에 스위치 저장 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		switches = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		
		// 2. 학생들만큼 반복문 수행 
		int num = Integer.parseInt(br.readLine());
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			
			int sex = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			
			// 3. 성별 구분 
			if( sex == 1 ) {
				boy(number);
			}
			else {
				if( switches[number] == 1 ) {
					switches[number] = 0;
				}
				else {
					switches[number] = 1;
				}
				girl(number);
			}
		}
		for(int i = 1; i <= N; i++) {
			System.out.print(switches[i] + " ");
            if( i % 20 == 0 ) System.out.println();
		}
		
	}
	
	public static void boy(int num) {
		// 배수만큼 change 
		int count = N / num;
		for(int i = 1; i <= count; i++) {
			int a = switches[i * num];
			
			if( a == 1 ) switches[ i*num ] = 0;
			else switches[ i*num ] = 1;
		}
	}
	
	public static void girl(int num) {
		// num 기준으로 대칭이면 범위 넓혀가기 
		int balance = 1;
		while(true) {
			// 1. 대칭 숫자는 범위 내에 있어야 
			if( num - balance >= 1 && num + balance <= N ) {
				int left = switches[num - balance];
				int right = switches[num + balance];
				
				// 2. 대칭은 값이 같아야 
				if( left == right ) {
					if( left == 0 ) {
						switches[num-balance] = 1;
						switches[num+balance] = 1;
					}
					else {
						switches[num-balance] = 0;
						switches[num+balance] = 0;
					}
					balance ++;
				}
				else break;
			}
			else break;
		}
	}
}