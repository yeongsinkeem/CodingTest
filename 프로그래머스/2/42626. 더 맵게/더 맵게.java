import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 1. pq 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        // 2. pq 준비
        while( pq.size() > 1 && pq.peek() < K) {
            int a = pq.poll();
            int b = pq.poll();
            
            int newScoville = a + (b * 2);
            answer++;
            
            pq.offer(newScoville);
        }
        
        return pq.peek() < K ? -1 : answer;
    }
}