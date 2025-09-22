import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int bitset = 0;
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			int num;
			
			switch(s) {
			case "add":
				num = Integer.parseInt(st.nextToken());
				bitset |= (1<<(num-1));
				break;
			
			case "remove":
				num = Integer.parseInt(st.nextToken());
				bitset &= ~(1<<(num-1));
				break;
				
			case "check":
				num = Integer.parseInt(st.nextToken());
				// 해당 원소가 있다면 -> 1 출력 
				if( (bitset & (1<<(num-1))) != 0 ) 
					sb.append(1).append("\n");
				else 
					sb.append(0).append("\n");
				break;
				
			case "toggle":
				num = Integer.parseInt(st.nextToken());
				bitset ^= ( 1<<(num-1));
				break;
			
			case "empty":
				bitset = 0;
				break;
				
			case "all":
				// 1을 21개 만들고 거기서 -1을 하면 1이 20개 생성 ! 
				bitset = (1<<20) - 1;
				break;
			}
		}
		
		System.out.println(sb.toString());
		
	}
}