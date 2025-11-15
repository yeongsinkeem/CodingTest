import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        // 1. 정렬
        Arrays.sort(people);
        
        int right = people.length - 1;
        int left = 0;
        
        while(left <= right) {
            answer++;
            
            // 만약 둘 다 태울 수 있다면 
            if( people[left] + people[right] <= limit ) left++;
            
            right--;
        }
        
        return answer;
    }
}