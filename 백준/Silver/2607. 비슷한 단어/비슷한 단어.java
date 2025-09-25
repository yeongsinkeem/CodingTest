import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String firstword = br.readLine();
        int count = 0; 
        
        // 1. 첫 번째 알파벳 사전 생성 
        int[] firstArr = new int[26];
        for(char ch: firstword.toCharArray()) {
            firstArr[ch - 'A'] ++;
        }
        
        for(int i = 1; i < num; i++) {
            String secondword = br.readLine();
            int[] secondArr = new int[26];
            int diff = 0; 
            // 2. 두 번째 알파벳 사전 생성 
            for(char ch: secondword.toCharArray()) {
                secondArr[ch - 'A']++;
            }
            
            // 3. 비교 차이 계산
            for(int j = 0; j < 26; j++) {
                diff += Math.abs(firstArr[j] - secondArr[j]);
            }
            
            // 4. 길이 비교 
            if( Math.abs(firstword.length() - secondword.length()) > 1 ) continue;
            
            if ( diff <= 1 ) count++;
            if ( diff == 2 && firstword.length() == secondword.length() ) count++;
        }
        
        System.out.println(count);
    }
}