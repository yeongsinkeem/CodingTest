import java.util.*;

class Solution {
    boolean solution(String s) {
        if( !s.contains("(") ) return false;
        
        char[] c = s.toCharArray();
        Queue<Character> queue = new LinkedList<>();
        int open = 0;
        int close = 0;
        
        // 1. 열린 괄호라면 큐에 넣기
        for(int i = 0; i < c.length; i++) {
            if( c[i] == '(' ) {
                queue.offer(c[i]);
                open++;
            }
            else {
                queue.poll();
                close++;
            }
        }
        
        if( queue.isEmpty() && (open == close) )return true;
        else return false;
    }
}