import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        // 1. 정렬
        Arrays.sort(times);
        long min = 1;
        long max = (long) ( times[times.length - 1] * (long) n) ; // 최대로 걸리는 시간
        
        while(min <= max) {
            long mid = (long) ((min + max) / 2);
            long sum = 0;
            
            for(int t : times) {
                // mid 시간 동안 심사관들이 처리하는 인원 수
                sum += (long) (mid / t);
                
                if ( sum >= n ) break;
            }
            
            // 2. n 시간 동안 전체 인원 처리 가능하다면 
            // max 감소
            if(n <= sum) {
                max = mid - 1;
                answer = mid;
            }
            
            // 3. n 시간 동안 처리 불가능하다면 
            else {
                min = mid + 1;
            }
        }
        
        return answer;
    }
}