import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> s = new Stack<>();
        
        for(char c : number.toCharArray() ) {
            while( k > 0 && !s.isEmpty() && s.peek() < c ) {
                k--;
                s.pop();
            }
            s.push(c);
        }
        
        if( k > 0 ) {
            for(int i = 0; i < k; i++) {
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