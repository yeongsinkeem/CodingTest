import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        // 1. participant 원소 map에 저장
        for(String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        // 2. completion 순회하면서 count 계산
        for(int i = 0; i < completion.length; i++) {
            // map에 해당 key 가 있다면 
            if ( map.containsKey(completion[i]) ) {
                int count = map.get(completion[i]);
                map.put(completion[i], count - 1);
            }
        }
        
        // 3. key로 value 접근 
        // System.out.println(map.get("leo"));
        for(String name : map.keySet()) {
            if( map.get(name) == 1 ) {
                return name;
            }
        }
    
        return answer;
    }
}