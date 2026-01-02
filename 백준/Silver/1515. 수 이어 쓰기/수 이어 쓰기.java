import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        
        int idx = 0;
        // 1부터 시작 
        int num = 1;
        
        while (true) {
            String s = String.valueOf(num);
            
            for(int i = 0; i < s.length(); i++) {
                // 1. 현재 처리 중인 idx의 요소를 num이 가지고 있다면 
                if( idx < line.length() && line.charAt(idx) == s.charAt(i) ) idx++;
                
                if( idx == line.length() ) {
                    System.out.println(num);
                    return;
                }
            }
            // 2. num은 계속해서 증가
            num++;
        }
 
    }
}