
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		int sum = 0;
		
		// 1. 예산 설정 
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int req = Integer.parseInt(st.nextToken());
			num[i] = req;
			sum += req;
		}
		
		st = new StringTokenizer(br.readLine());
		int limit = Integer.parseInt(st.nextToken());
		
        Arrays.sort(num);
		// 2. 상한액 지정 여부 
		int left = 0;
		int right = num[N-1];
		int ans = 0; 

		while(left <= right) {
			int mid = (left + right) / 2;
			int temp = 0; 
			
			for(int x : num) {
				// 평균 전까지만 더하고 
				// 평균을 이동하는 방식 
				temp += Math.min(x, mid);
			}
			
			if(temp <= limit) {
				ans = mid;
				left = mid + 1; 
			}
			
			else {
				right = mid - 1;
			}
		}
		
		System.out.println(ans);
		
	}
}