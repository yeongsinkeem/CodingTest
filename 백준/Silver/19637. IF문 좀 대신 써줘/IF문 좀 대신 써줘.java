import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 09 : 24 ~ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 1. 칭호와 전투력 저장 
        String[] name = new String[N];
        long[] power = new long[N];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	name[i] = st.nextToken();
        	power[i] = Long.parseLong(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        
        // 2. 이분탐색 
        for(int i = 0; i < M; i++) {
        	long k = Long.parseLong(br.readLine());
        	
        	int left = 0;
        	int right = N - 1;
        	int answer = 0;
        	
        	while( left <= right ) {
        		int mid = (left + right) / 2;
        		
        		// 왼쪽 탐색 
        		if( k <= power[mid] ) {
        			answer = mid;
        			right = mid - 1;
        		}
        		else {
        			left = mid + 1;
        		}
        	}
        	
        	sb.append(name[answer]).append("\n");
        }
		
		System.out.println(sb.toString());
	}
}
