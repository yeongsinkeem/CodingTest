import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int len = s.length();
        Queue<Character> q = new LinkedList<>();
        
        for(char c : s.toCharArray()) {
            q.offer(c);
        }
        
        for(int i = 0; i < len; i++) {
            // 1. i번째 큐에 대해서 
            StringBuilder now = new StringBuilder();
            for(char c : q) {
                now.append(c + "");
            }
            
            // 2. 올바른 괄호인지 확인
            String nowS = now.toString();
            if( isCorrect(nowS) ) answer++;
            
            char firstC = q.poll();
            q.offer(firstC);
        }
        return answer;
    }
    
    public boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        
        // 1. 열린 괄호라면 스택에 넣기 
        for(char c : s.toCharArray()) {
            if( c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            
            // 2. 같은 종류의 괄호일 것 
            else if( !stack.isEmpty() && c - stack.peek() <= 2 ) {
                stack.pop();
            }
            
            // 3. 만약 첫 요소가 닫힌 괄호라면 X
            else if( stack.isEmpty() && (c == ')' || c == '}' || c == ']' ) ) {
                return false;
            }
        }
        
        if( stack.isEmpty() ) return true;
        
        return false;
    }

}