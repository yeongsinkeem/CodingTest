import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        // 1. times 정렬
        Arrays.sort(times);
        
        long min = 1;
        long max = (long)times[times.length - 1] * n;
        
        while( min <= max ) {
            long sum = 0;
            long mid = (min + max) / 2;
            // 2. mid 시간 동안 처리할 수 있는 인원 계산 
            for(int time : times) {
                sum += mid / time;
                // 더이상 처리할 필요 x
                if( sum >= n ) break;
            }
            
            // 3 - 1. 만약 해당 시간 내에 처리 x -> 시간 더 늘려야 함
            if( sum < n ) {
                min = mid + 1;
            }
            // 3 - 2. 해당 시간 내에 처리 o -> 더 적은 시간 탐색 
            else {
                answer = mid;
                max = answer - 1;
            }
        }
        
        return answer;
    }
}