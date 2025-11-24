import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        
        for(int dep : d) {
            if( budget - dep >=  0 ) {
                budget -= dep;
                answer++;
            }
            
            else {
                break;
            }
        }
        
        return answer;
    }
}