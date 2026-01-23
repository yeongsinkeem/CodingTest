import java.util.*;

class Solution {
    boolean solution(String s) {
        if( !s.contains("(") ) return false;
        
        char[] c = s.toCharArray();
        Queue<Character> queue = new LinkedList<>();
        int open = 0;
        int close = 0;
        
        // 1. 열린 괄호라면 큐에 넣기
        for(int j = 0; j < c.length; j++) {
            if( c[j] == '(' ) {
                queue.offer(c[j]);
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