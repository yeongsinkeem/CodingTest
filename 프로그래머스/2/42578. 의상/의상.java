import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
    
        // 1. category 별로 저장
        for(int i = 0; i < clothes.length; i++) {
            String category = clothes[i][1];
            map.put(category, map.getOrDefault(category, 0) + 1);
        }
        
        // 2. answer 계산
        // category == 1개라면
        if(map.size() == 1) {
            for(int value : map.values())
                return value;
        }
        // category >= 2개라면
        // answer = (A 카테고리 + 1) * (B 카테고리 + 1) ... - 1
        int answer = 1;
        for(int value : map.values()) {
            answer *= value + 1;
        }
        
        return answer - 1;
    }
}