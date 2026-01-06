import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = s.length();
		
		// 1. 0과 1의 개수 세기 
		int zero = 0;
		int one = 0;
		
		for( char c : s.toCharArray() ) {
			if( c == '0' ) zero ++;
			else one ++;
		}
		
		// 2. 절반으로 개수 줄이기 
		zero = zero / 2;
		one = one / 2;
		
		String newS = "";
		
		// removed 배열 사용 
		// 제거 여부 표시해서 
		// 제거되지 않은 문자열들이 정답 
		boolean[] removed = new boolean[n];
		
		// 3. 1은 앞 인덱스부터 제거
		for(int i = 0; i < n; i++) {
			if( s.charAt(i) == '1' && one > 0 ) {
				removed[i] = true;
				one--;
			}
		}
		
		// 4. 0은 뒷 인덱스부터 제거 
		for(int i = n-1; i >= 0; i--) {
			if( s.charAt(i) == '0' && zero > 0 ) {
				removed[i] = true;
				zero--;
			}
		}
		
		// 5. 출력 
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			// 제거되지 않았다면 
			if( !removed[i] ) {
				sb.append(s.charAt(i));
			}
		}
		
		System.out.println(sb);
		
		
		// 해당 풀이법 안 되는 이유 
		// : 원래 문자열의 순서를 유지하지 못함 
		/*
		// 3. 절반만큼 새롭게 붙이기 
		for(int i = 0; i < zero; i++) {
			newS += "0";
		}
		for(int i = 0; i < one; i++) {
			newS += "1";
		}
		
		// 4. 정렬 
		List<Character> lst = new ArrayList<>();
		for(char c : newS.toCharArray()) {
			lst.add(c);
		}
		
		lst.sort( (a, b) -> {
			return a - b;
		});
		
		for( char c : lst )
			System.out.print(c);
		*/
	}
}