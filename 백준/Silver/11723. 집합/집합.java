import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static Set<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String method = st.nextToken();
			
			// add, remove, toggle : 원소 추가
			if( method.equals("add") ) {
				int element = Integer.parseInt(st.nextToken());
				set.add(element);
			}
			else if( method.equals("remove") ) {
				int element = Integer.parseInt(st.nextToken());
				set.remove(element);
			}
			else if( method.equals("toggle") ) {
				int element = Integer.parseInt(st.nextToken());
				
				if( set.contains(element) ) set.remove(element);
				else set.add(element);
			}
			else if( method.equals("check") ) {
				int element = Integer.parseInt(st.nextToken());
				
				if( set.contains(element) ) sb.append("1\n");
				else sb.append("0\n");
			}
			else if( method.equals("all") ) {
				// set = new HashSet<>();
				for(int j = 1; j <= 20; j++) set.add(j);
			}
			else if( method.equals("empty")) {
				set = new HashSet<>();
			}
		}
		
		System.out.println(sb.toString());
	}
}