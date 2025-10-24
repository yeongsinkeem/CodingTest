import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        // 1. HashMap에 각 카드의 종류와 개수 저장
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            // map.put(key, value)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1 );
        }
        
        // 2. 폰켓몬 수 출력
        // 카드가 다양하지 않다면 
        if( map.size() <= (nums.length) / 2 ) {
            return map.size();
        }
        
        // 카드가 다양하다면 
        else {
            return nums.length / 2;
        }
    }
}