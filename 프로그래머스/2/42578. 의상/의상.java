// 13 : 18 ~ 
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        
        // 1. 카테고리 별로 종류 개수 저장
        for(int i = 0; i < clothes.length; i++) {
            String category = clothes[i][1];
            
            map.put(category, map.getOrDefault(category, 0) + 1);
        }
        
        for(String category : map.keySet()) {
            answer *= map.get(category) + 1;
        }
        return answer - 1;
    }
}