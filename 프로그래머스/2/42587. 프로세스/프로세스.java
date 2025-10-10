import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Collections;

class Solution {
    class Process {
        int idx;
        int priority;
        
        public Process(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 1. 초기화
        Queue<Process> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < priorities.length; i++) {
            queue.add(new Process(i, priorities[i]));
            pq.add(priorities[i]);
        }
        
        while(!queue.isEmpty()) {
            Process now = queue.poll();
            
            // 2. 우선순위가 낮다면 
            if(now.priority < pq.peek()) {
                queue.add(now);
            }
            // 3. 우선순위가 높다면 
            else {
                answer ++;
                pq.poll();
                
                // 4. 목표 원소라면 
                if(now.idx == location) {
                    return answer;
                }
            }
        }
        return answer;
    }
}