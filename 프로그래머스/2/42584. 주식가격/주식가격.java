import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        // 1. 큐에 요소 넣기
        Queue<Integer> q = new LinkedList<>();
        for(int p : prices) {
            q.offer(p);
        }
        
        int idx = 0;
        while( !q.isEmpty() ) {
            int seconds = 0;
            int element = q.poll();
            
            for(int a : q) {
                seconds++;
                // 가격이 떨어졌다면 
                if( a < element ) break;
            }
            
            answer[idx] = seconds;
            idx++;
        }
        return answer;
    }
}