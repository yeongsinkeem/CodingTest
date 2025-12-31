import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean flag = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String t = br.readLine();
		
		DFS(t, s);
		
		if(flag) System.out.println(1);
		else System.out.println(0);
	}
	
	// curr -> target 으로 줄여나가기 
	public static void DFS(String curr, String target) {
		if( curr.length() == target.length() ) {
			// s -> t로 만들 수 있는 경우
			if( curr.equals(target) ) flag = true;
			return;
		}
		
		// 1. 마지막 요소가 a 라면 -> a 제거 
		if( curr.charAt(curr.length() - 1) == 'A' ) {
			DFS(curr.substring(0, curr.length() - 1), target);
		}
		
		// 2. 첫 요소가 b 라면 .. 얘가 혹시 뒤집어서 만들어진것인지 확인 
		// 즉 역연산하여, targe 될 수 있는지 확인 
		// 원래 : 맨 뒤 B 붙이고 -> reverse
		// 역연산한 결과 : 맨 앞 B 오고 -> 나머지 reverse 
		if( curr.charAt(0) == 'B' ) {
			// 2-1. B 제거 -> 뒤집기 
			String next = new StringBuilder(curr.substring(1)).reverse().toString();
			DFS(next, target);
		}
	}
}