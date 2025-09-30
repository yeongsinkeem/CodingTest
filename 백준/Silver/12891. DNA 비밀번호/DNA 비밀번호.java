import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] wArr;
	static int[] tArr;
	static int checkSecret = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 전체 dna 배열 길이 
		int M = Integer.parseInt(st.nextToken()); // 윈도우 길이 
		int count = 0;
		
		char[] dna = new char[N];
		dna = br.readLine().toCharArray();
		
		wArr = new int[4]; // 내 윈도우 배열 
		tArr = new int[4]; // 정답 배열 
		
		// 1. 정답 배열 값 넣기 
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			tArr[i] = Integer.parseInt(st.nextToken());
			
			if(tArr[i] == 0) {
				checkSecret++;
			}
		}
		
		// 2. wArr 초기 값 설정 - dna 활용 
		for(int i = 0; i < M; i++) {
			Add(dna[i]);
		}
		if(checkSecret == 4) {
			count++;
		}
		
		// 3. 윈도우 시작 : 두번째 값 ~ 맨마지막까지 
		for(int i = M; i < N; i++) {
			int j = i - M;
			Add(dna[i]);
			Remove(dna[j]);
			
			if(checkSecret == 4) {
				count++;
			}
		}
		System.out.println(count);
		br.close();
	}

	public static void Add(char c) {
		switch(c) {
		case 'A':
			wArr[0]++;
			if(wArr[0] == tArr[0]) checkSecret++;
			break;
		case 'C':
			wArr[1]++;
			if(wArr[1] == tArr[1]) checkSecret++;
			break;
		case 'G':
			wArr[2]++;
			if(wArr[2] == tArr[2]) checkSecret++;
			break;
		case 'T':
			wArr[3]++;
			if(wArr[3] == tArr[3]) checkSecret++;
			break;
		}
	}
	
	private static void Remove(char c) {
		switch(c) {
		case 'A':
			if(wArr[0] == tArr[0]) checkSecret--;
			wArr[0]--;
			break;
		case 'C':
			if(wArr[1] == tArr[1]) checkSecret--;
			wArr[1]--;
			break;
		case 'G':
			if(wArr[2] == tArr[2]) checkSecret--;
			wArr[2]--;
			break;
		case 'T':
			if(wArr[3] == tArr[3]) checkSecret--;
			wArr[3]--;
			break;
		}
	}
}