import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 1. participant hashMap 저장 
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < participant.length; i++) {
            String name = participant[i];
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        // 2. completion 순회하면서 value가 1인 것 출력
        for(int i = 0; i < completion.length; i++) {
            if(map.containsKey(completion[i])) {
                // 3. key(name)로 value(count) 찾아 -> value 감소 
                map.put(completion[i], map.getOrDefault(completion[i], 0) - 1);
            }
        }
        
        // 4. 완주하지 못한 선수 출력(value == 1)
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                answer = entry.getKey();
            }
        }

        
        return answer;
    }
}