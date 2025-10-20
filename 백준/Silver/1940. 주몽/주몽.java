import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nArr = new int[N];
        
        for(int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(nArr);
        // 투포인터 
        int s_idx = 0;
        int e_idx = N - 1;
        
        int count = 0;
        while(s_idx < e_idx) {
            int sum = nArr[s_idx] + nArr[e_idx];
            
            if(sum < M) {
                s_idx++;
            }
            else if(sum > M) {
                e_idx--;
            }
            else {
                count ++;
                s_idx++;
                e_idx--;
            }
        }
        System.out.println(count);
    }
}