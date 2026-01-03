import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		char[] arr = new char[N];
		String line = br.readLine();
		
		// 1. 햄버거 / 사람 저장 
		for(int i = 0; i < N; i++) {
			arr[i] = line.charAt(i);
		}
		
		// 2. N 순회 
		int count = 0;
		for(int i = 0; i < N; i++) {
			boolean ate = false;
			for(int j = K; j >= 1; j--) {
				if(i - j >= 0 && arr[i] == 'P' && arr[i-j] == 'H') {
					// System.out.println(i + 1 + "번 먹음(이전)");
					count++;
					arr[i-j] = 'A';
					ate = true;
					break; // 가장 인접한 for문 탈출 
				}
			}
			
			if( !ate ) {
				for(int j = 1; j <= K; j++) {
					if(i + j < N && arr[i] == 'P' && arr[i+j] == 'H') {
						// System.out.println(i + 1 + "번 먹음(이후)");
						count++;
						arr[i+j] = 'A';
						ate = true;
						break;
					}
				}
			}
		}
		
		System.out.println(count);
	}
}