import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int curr = 0;
        for(int s : section) {
            // 색칠해야 함
            if( curr < s ) {
                answer++;
                curr = s + m - 1;
            }
        }
        
        return answer;
    }
}