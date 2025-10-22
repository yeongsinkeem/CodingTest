import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        char[] sChar = s.toCharArray();
        for(int i = 0; i < sChar.length; i++) {
            // 열린 괄호라면 push
            if(sChar[i] == '(') {
                stack.push(sChar[i]);
            }
            // 닫힌 괄호라면 pop
            else {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}