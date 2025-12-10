import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> sub = new Stack<>();
        
        int idx = 0;
        for(int i = 1; i <= order.length; i++) {
            // 1. 만약 순서가 동일하다면 
            if( i == order[idx] ) {
                answer++;
                idx++;
            }
            // 2. 다르면 stack에 넣기 
            else {
                sub.push(i);
            }
            
            // sub : 1, 2, 3
            while( !sub.isEmpty() && sub.peek() == order[idx] ) {
                sub.pop();
                answer++;
                idx++;
            }
        }
        
        return answer;
    }
}