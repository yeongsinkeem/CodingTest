import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = "";
		
		while( true ) {
			word = br.readLine();
			
			if (word.equals("end")) break;
			
			// 1-1. 모음 포함 여부 확인 
			boolean flag = false;
			for(char c : word.toCharArray()) {
				if( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ) {
					flag = true;
					break;
				}
			}
			// 1-2. 만약 모음 없다면 바로 종료 
			if( !flag ) {
				System.out.println("<" + word + "> is not acceptable.");
				continue;
			}
			
			// 2. 3개 연속 자음/모음 X
			if( isThree(word) ) {
				System.out.println("<" + word + "> is not acceptable.");
				continue;
			}
			
			// 3. 같은 글자 연속 x
			if( isSameTwo(word) ) {
				System.out.println("<" + word + "> is not acceptable.");
				continue;
			}
			
			System.out.println("<" + word + "> is acceptable.");
		}
	}
	
	public static boolean isThree(String s) {
		for(int i = 1; i < s.length() - 1; i++) {
			char a = s.charAt(i-1);
			char b = s.charAt(i);
			char c = s.charAt(i+1);
			
			// 모두 모음 
			if( a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' ) {
				if( b == 'a' || b == 'e' || b == 'i' || b == 'o' || b == 'u' ) {
					if( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ) {
						return true;
					}
				}
			}
			// a가 자음일 때 -> b, c도 자음이면 종료 
			else {
				if( b != 'a' && b != 'e' && b != 'i' && b != 'o' && b != 'u' ) {
					if( c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' ) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public static boolean isSameTwo(String s) {
		for(int i = 0; i < s.length() - 1; i++) {
			char a = s.charAt(i);
			char b = s.charAt(i + 1);
			
			if( a == b ) {
				if( a == 'e' || a == 'o' ) continue;
				return true;
			}
		}
		
		return false;
	}
}