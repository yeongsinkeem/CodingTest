import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int disLen = discount.length;
        
        // 1. 정현이 map 생성
        Map<String, Integer> wMap = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            wMap.put(want[i], number[i]);
        }
        
        // 2. discount 순회하면서 discountMap 생성
        for(int i = 0; i < disLen - 10 + 1; i++) {
            Map<String, Integer> dMap = new HashMap<>();
            
            for(int j = 0; j < 10; j++) {
                String item = discount[i+j];
                dMap.put( item, dMap.getOrDefault(item, 0) + 1 );
            }
            
            // 3. wMap과 dMap 비교 
            int cnt = 0;
            for(String w : wMap.keySet()) {
                if( dMap.containsKey(w) && wMap.get(w) <=  dMap.get(w) ) {
                    cnt++;
                }
            }
            
            if( cnt == wMap.size() ) answer++;
        }
        
        
        return answer;
    }
}