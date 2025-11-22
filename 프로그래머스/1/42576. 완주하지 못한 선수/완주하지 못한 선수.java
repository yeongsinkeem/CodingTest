import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        
        // 1. participant 순회하면서 map에 이름, 횟수 넣기
        for(String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        // 2. completion 순회하면서 완주했으면 횟수 감소하기
        for(String c : completion) {
            if( map.containsKey(c) ) {
                int cnt = map.get(c) - 1;
                // 제거 -> 다시 넣기
                map.remove(c);
                map.put(c, map.getOrDefault(c, cnt));
            }
        }
        
        for(String p : map.keySet()) {
            if( map.get(p) == 1 ) return p;
        }
        
        return answer;
    }
}