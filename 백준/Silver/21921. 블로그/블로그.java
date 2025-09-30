import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		// 1. blog 배열에 숫자 저장 
		int[] blog = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			blog[i] = Integer.parseInt(st.nextToken());
		}
		
		// 2. 초기 세팅 
		int sum = 0; 
		for(int i = 0; i < X; i++) {
			sum += blog[i];
		}
		int maxValue = sum;
		int count = 1; 
		// 3. 슬라이딩 윈도우
		for(int i = X; i < N; i++) {
			int j = i - X; 
			sum += blog[i];
			sum -= blog[j];
			
			// 4. 만약 sum이 최댓값이 된다면 
			if(sum > maxValue) {
				maxValue = sum;
				count = 1;
			}
			else if(sum == maxValue) {
				count ++;
			}
		}
		
		if(maxValue == 0) {
			System.out.println("SAD");
		}
		else {
			System.out.println(maxValue);
			System.out.println(count);
		}
	}
}