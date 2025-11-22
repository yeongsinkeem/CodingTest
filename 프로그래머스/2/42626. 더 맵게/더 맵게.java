import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
        
        // 1. 계속 정렬이 일어나야 함 -> minHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) {
            pq.offer(s);
        }
        
        // 2. 스코빌 지수 만들기
        while( pq.size() >= 2 && pq.peek() < K ) {
            count++;
            int first = pq.poll();
            int second = pq.poll();
            
            int mixed = first + (second * 2);
            pq.offer(mixed);
        }
        
        if( pq.peek() < K ) return -1;
        
        return count;
    }
}