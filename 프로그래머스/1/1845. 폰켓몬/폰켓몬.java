import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int halfN = nums.length / 2;
        
        // 종류가 더 작다면 
        if( map.size() < halfN ) return map.size();
        return halfN;
    }
}