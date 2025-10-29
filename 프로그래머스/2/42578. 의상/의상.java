import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // 1. category + type으로 map에 저장
        Map<String, Integer> map = new HashMap<>();
        
        // 2. type의 개수 + 1이 type으로 할 수 있는 조합 수 
        for(int i = 0; i < clothes.length; i++) {
            map.put( clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        // 3. 계산 
        for(String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }
        
        /* 
        for(String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
        */ 
        
        // 3. 이때 전체 개수에서 아무것도 입지 않은 경우는 제외할 것.
        answer -= 1;
        return answer;
    }
}