import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
		public static void main(String[] args) throws NumberFormatException, IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.parseInt(br.readLine());
	        
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        // 1. 배열 생성 
	        int[] arr = new int[N];
	        for(int i = 0; i < N; i++) {
	        	int num = Integer.parseInt(st.nextToken()); // 자기보다 큰 사람 몇 명인지 
	        	
	        	int count = 0; // 배열 내 빈칸 개수 
	        	for(int j = 0; j < N; j++) {
	        		if( arr[j] == 0 && count == num ) {
	        			// 내 자리 발견 
	        			arr[j] = i + 1;
	        			break;
	        		}
	        		
	        		else if( arr[j] == 0 && count < num ) count++;
	        	}
	        }
	        
	        for(int a : arr) {
	        	System.out.print(a + " ");
	        }
		}
}