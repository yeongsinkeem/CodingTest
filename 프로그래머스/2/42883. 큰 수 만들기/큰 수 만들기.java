import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        
        for(char c : number.toCharArray()) {
            // stack.peek() < c -> stack.pop -> stack.push(c)
            while( k > 0 && !stack.isEmpty() && stack.peek() < c ) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        // k 개의 수 다 제거하지 않았을 때 
        if( k > 0 ) {
            for(int i = 0; i < k; i++) {
                stack.pop();
            }
        }
        
        // stack = FILO
        // 그치만 순서 자체는 FIFO임 !
        StringBuilder sb = new StringBuilder();
        for(char c : stack) {
            sb.append(c);
        }
        
        answer = sb.toString();
        return answer;
    }
}