import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// Y = 2, F = 3, O = 4
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		String game = st.nextToken();
		
		// 1. 이름 Set에 저장 
		Set<String> set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			String name = br.readLine();
			set.add(name);
		}
		
		if( game.equals("Y") ) {
			System.out.println( set.size() / 1);
		}
		else if( game.equals("F") ) {
			System.out.println( set.size() / 2);
		}
		else {
			System.out.println( set.size() / 3);
		}
	}
}