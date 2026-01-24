import java.util.*;

class Solution {
    public String solution(String number, int k) {
        // String answer = "";
        Stack<Character> s = new Stack<>();
        
        for(char c : number.toCharArray()) {
            // 스택 요소보다 그 다음 요소가 크다면 
            while( k > 0 && !s.isEmpty() && s.peek() < c) {
                k--;
                s.pop();
            }
            s.push(c);
        }
        
        // 아직 덜 제거 
        // 가장 뒷 요소부터 제거 
        // 왜냐. 앞 요소들은 최선이기 때문
        if( k > 0 ) {
            for(int j = 0; j < k; j++) {
                s.pop();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : s) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}