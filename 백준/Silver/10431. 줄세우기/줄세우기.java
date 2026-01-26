import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int P = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < P; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int T = Integer.parseInt(st.nextToken());
			
			// 1. 배열 설정 
			int[] arr = new int[20];
			for(int j = 0; j < 20; j++) {
				int curr = Integer.parseInt(st.nextToken());
				arr[j] = curr;
			}
			
			// 2. 정렬 
			int sum = 0;
			for(int j = 0; j < 20; j++) {
				// 나보다 큰 애들만큼 더하기 
				for(int k = 0; k < j; k++) {
					if(arr[k] > arr[j]) {
						sum ++;
					}
				}
			}
			
			System.out.println( T + " " + sum);
		}
	}

}