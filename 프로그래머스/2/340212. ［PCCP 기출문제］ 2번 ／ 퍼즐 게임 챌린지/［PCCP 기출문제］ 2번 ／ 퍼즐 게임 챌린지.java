import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int[] copy = Arrays.copyOfRange(diffs, 0, diffs.length);
        Arrays.sort(copy);
        
        int left = 1;
        int right = copy[copy.length - 1];
        
        int level = 0;
        while(left <= right) {
            level = (left + right) / 2;
            long seconds = 0;
            
            // 1. diffs 순회하면서 seconds 계산
            for(int i = 0; i < diffs.length; i++) {
                // level이 높다면 : 해당 레벨 통과 
                if( level >= diffs[i] ) {
                    seconds += times[i];
                }
                // level이 낮다면 : 이전 단계 + 해당 레벨 
                else {
                    seconds += (times[i-1] + times[i]) * (diffs[i] - level) + times[i];
                }
                
                if( seconds > limit ) break;
            }
            
            if( seconds <= limit ) {
                right = level - 1;
                answer = level;
            }
            else {
                left = level + 1;
            }
        }
        
        return answer;
    }
}