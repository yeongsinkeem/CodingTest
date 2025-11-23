import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        // 1. map 정렬하기 위해 entry"List" 준비
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        
        // 2. entryList 정렬
        // 이때 entry로부터 값을 가져오는 것이기 때문에
        // getValue() 함수 사용 
        // 내림차순
        Collections.sort(entryList, (o1, o2) -> (o2.getValue() - o1.getValue()));
        
        for( Map.Entry<Integer, Integer> entry : entryList ) {
            k -= entry.getValue();
            answer++;
            
            if( k <= 0 ) return answer;
        }
        
        
        return answer;
    }
}