import java.util.*;

class Solution {
    Queue<Character> q;
    
    public int solution(String s) {
        int answer = 0;
        String newS = "";
        
        // 1. Queue 만들기
        q = new LinkedList<>();
        for(char c : s.toCharArray()) {
            q.offer(c);
        }
        
        // 2. s를 왼쪽으로 x칸만큼 회전하기
        for(int i = 0; i < s.length(); i++) {
            
            // 3. 현재 큐의 상태를 문자열로 만들기
            String curr = "";
            for(char c : q) {
                curr += c + "";
            }
            
            if( isCorrect(curr) ) answer++;
            
            // 4. 큐 업데이트 
            q.offer(q.poll());
        }
        
        return answer;
    }
    
    // 올바른 괄호 문자열인지 아닌지 판단
    public boolean isCorrect(String s) {
        
        Stack<Character> openS = new Stack<>();
        char[] charArr = s.toCharArray();
        
        // 첫 요소가 바로 닫힌 괄호 -> X 
        if( charArr[0] == ']' || charArr[0] == ')' || charArr[0] == '}' ) return false;
        
        for(char c : charArr) {
            if( c == '(' || c == '{' || c == '[' ) {
                openS.push(c);
            }
            
            else if( !openS.isEmpty() ) {
                char preChar = openS.peek();
                
                // 만약 짝이 맞다면 -> 스택에서 꺼내주기 
                if( c - preChar <= 2 ) {
                    openS.pop();
                }
            }
        }
        
        if( openS.size() > 0 ) return false;
        
        return true;
    }
}