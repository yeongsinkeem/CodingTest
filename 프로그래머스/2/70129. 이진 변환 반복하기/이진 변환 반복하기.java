import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        if( s.equals("1") ) {
            answer[0] = 0;
            answer[1] = 0;
            
            return answer;
        }
        
        int zeroCnt = 0;
        int round = 0;
        
        while( !s.equals("1") ) {
            String newS = "";
            round += 1;
            
            // 1. 0 없애기 
            for(int i = 0; i < s.length(); i++) {
                if( s.charAt(i) == '1' ) {
                    newS += s.charAt(i) + "";
                }
                else {
                    zeroCnt += 1;
                }
            }
            
            // 2. 제거 후 길이 구하기 
            int newSLen = newS.length();
            
            // 3. 이진수로 변환 
            s = toBinary(newSLen);
        }
        
        answer[0] = round;
        answer[1] = zeroCnt;
        
        return answer;
    }
    
    public String toBinary(int a) {
        Stack<Integer> stack = new Stack<>();
        String binaryS = "";
        
        // 몫이 1보다 크거나 같을 때까지만 수행 
        while( a > 1 ) {
            stack.push( a % 2 );
            a = a / 2;
        }
        
        stack.push(a);
        
        while( !stack.isEmpty() ) {
            binaryS += stack.pop() + "";
        }
        
        return binaryS;
    }
}