import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1. 문자열 길이 
		String s = br.readLine();
		int sLen = s.length();
		
		// 2. a 개수 세기 
		int aCount = 0;
		for(char c : s.toCharArray()) {
			if( c == 'a' ) aCount++;
		}
		
		// 3. a 개수 -> 슬라이딩 윈도우 생성 
		int answer = Integer.MAX_VALUE;
		// for(int i = 0; i < sLen - aCount; i++) {
		// 원형처리하기 때문에 sLen으로 가도 됨
		for(int i = 0; i < sLen; i++) {
			int bCount = 0;
			
			// 4. 해당 윈도우 내의 b의 최소 개수 
			for(int j = 0; j < aCount; j++) {
				if( s.charAt((i + j) % sLen) == 'b' ) bCount++;
			}
			answer = Math.min(answer, bCount);
		}
		
		System.out.print(answer);
	}
}