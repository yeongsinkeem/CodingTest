import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int newScore = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken()); // P = Limit
		
		// 랭킹 리스트에 아무도 없음 -> 1등 
		if( N == 0 ) {
			System.out.println(1);
			return;
		}
		
		st = new StringTokenizer(br.readLine());
		
		// 1. 배열에 점수들 저장하기 
		int[] scores = new int[N];
		for(int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}
		
		// 2. 랭킹이 꽉 차 있을 때는 -1 출력 
		if( N == P && newScore <= scores[P-1] ) {
			System.out.println(-1);
			return; 
		}
		
		// 3. 등수 계산
		int rank = 0;
		for(int i = 0; i < N; i++) {
			if( newScore < scores[i] ) rank++;
			else break;

		}
		
		System.out.println(rank + 1);
	}
}