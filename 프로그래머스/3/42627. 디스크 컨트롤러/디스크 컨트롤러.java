import java.util.*;

class Solution {
    class Process{
        int idx;
        int t1;
        int t2;
        
        public Process(int idx, int t1, int t2) {
            this.idx = idx;
            this.t1 = t1;
            this.t2 = t2;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, Comparator.comparingInt( a -> a[0]));
        
        // 1. 우선순위 큐 생성
        PriorityQueue<Process> pq = new PriorityQueue<>(
            Comparator.comparingInt( (Process p) -> p.t2)
                      .thenComparingInt(p -> p.idx)
        );
        
        int sum = 0;
        int seconds = 0;
        int idx = 0;
        
        while( idx < jobs.length || !pq.isEmpty() ) {
            // 2. 현재 시간까지 도착한 작업들 대기 큐에 삽입 
            while( idx < jobs.length && jobs[idx][0] <= seconds ) {
                pq.offer(new Process(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            // 3. 대기 큐에 작업이 없다면 시간 점프 
            if( pq.isEmpty() ) {
                seconds = jobs[idx][0];
                continue;
            }
            
            // 4. 시간 계산 
            Process p = pq.poll();
            seconds += p.t2;
            sum += seconds - p.t1;
        }
        
        return sum / jobs.length;
    }
}