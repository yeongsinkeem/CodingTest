import java.util.*;

class Solution {
    public class Process {
        int num;
        int value;
        
        public Process(int num, int value) {
            this.num = num;
            this.value = value;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 1. queue, pq 만들기
        Queue<Process> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // 2. 요소 넣기 
        for(int i = 0; i < priorities.length; i++) {
            queue.offer( new Process(i + 1, priorities[i]) );
            pq.offer(priorities[i]);
        }
        
        // 3. 조건 구현
        while( !queue.isEmpty() ) {
            Process process = queue.poll();
            // 4. 만약 현재 우선순위보다 높은 프로세스가 있다면 
            if( process.value < pq.peek() ) {
                queue.offer(process);
            }
            // 5. 현재 우선순위가 가장 높다면 
            else {
                pq.poll();
                answer ++;
                
                // 6. 문제에 해당하는 답 찾기
                if( process.num == location + 1) {
                    return answer;
                }   
            }
        }
        return answer;
    }
    
}