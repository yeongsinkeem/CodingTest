import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 1. jobs 정렬 
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        // 2. 우선순위 큐 생성
        PriorityQueue<int []> pq = new PriorityQueue<>( (a, b) -> a[1] - b[1] );
        
        // 3. 변수 초기화 
        int processCnt = 0;
        int jobIdx = 0;
        int totalAroundTime = 0;
        int currTime = 0;
        
        while( processCnt < jobs.length ) {
            // 4. 현재 시간 이전까지의 작업들 넣기 (초기 설정)
            while( jobIdx < jobs.length && jobs[jobIdx][0] <= currTime ) {
                pq.offer(jobs[jobIdx]);
                jobIdx++;
            }
            
            // 5. 큐가 비지 않았다면, 즉 작업 계속 할 수 있다면 
            if( !pq.isEmpty() ) {
                // 타임 리프 -> 시간 계산 -> processCnt 증가
                int[] curr = pq.poll();
                currTime += curr[1];
                totalAroundTime += currTime - curr[0];
                processCnt ++;
            }
            
            // 6. 큐가 비었다면 
            else {
                // 타임 건너뛰기
                currTime = jobs[jobIdx][0];
            }
        }
        return totalAroundTime / jobs.length;
    }
}