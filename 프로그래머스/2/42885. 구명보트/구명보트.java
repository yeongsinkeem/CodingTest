import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        // 1. 정렬
        Arrays.sort(people);
        
        int right = people.length - 1;
        int left = 0;
        
        while( left <= right ) {
            answer ++;
            
            if( people[right] + people[left] <= limit ) left ++;
            right --;
        }
        return answer;
    }
}