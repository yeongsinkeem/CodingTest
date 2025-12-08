import java.util.*;

class Solution {
    class task {
        private int idx;
        private int prior;
        
        public task(int idx, int prior) {
            this.idx = idx;
            this.prior = prior;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<task> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // 1. 요소 넣기
        for(int i = 0; i < priorities.length; i++) {
            q.offer(new task(i, priorities[i]));
            pq.offer(priorities[i]);
        }
        
        while( !q.isEmpty() ) {
            task curr = q.poll();
            
            // 2. 현재 요소보다 큰 게 있다면 
            if( curr.prior < pq.peek() ) {
                q.offer(curr);
            }
            else {
                pq.poll();
                
                answer++;
                if( location == curr.idx ) return answer;
            }
        }
        
        return answer;
    }
}