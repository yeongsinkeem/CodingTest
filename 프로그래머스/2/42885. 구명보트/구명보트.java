import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right) {
            // 2명 태울 수 있는 경우
            if( people[right] + people[left] <= limit) {
                left ++;
                right --;
            }
            else {
                right --;
            }
            answer++;
        }
        return answer;
    }
}