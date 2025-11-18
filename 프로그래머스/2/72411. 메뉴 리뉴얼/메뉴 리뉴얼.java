import java.util.*;

class Solution {
    // 메뉴 구성, 주문 횟수
    Map<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answerLst = new ArrayList<>();
        
        // 1. 각 코스 길이 별로 조합 구하기 
        for(int c : course) {
            map = new HashMap<>();
            
            for(String order : orders) {
                // 문자열 정렬 !!!
                char[] charArr = order.toCharArray();
                Arrays.sort(charArr);
                String sortedString = new String(charArr);
                
                // 해당 주문에서 c개의 메뉴를 뽑는 조합 생성 
                // ex "asdfg" 에서 2개 뽑아 조합 만들기 
                if( sortedString.length() >= c ) {
                    DFS(sortedString, "", 0, c);
                }
            }
            
            // 2. 해당 코스 길이에서 가장 많이 주문된 횟수 찾기
            int maxCount = 0;
            for(int count : map.values()) {
                maxCount = Math.max(maxCount, count);
            }
            
            // 3. 최소 2명 이상 주문 + 최댓값과 같은 메뉴 구성만 추가 
            if( maxCount >= 2 ) {
                for(String key : map.keySet()) {
                    if(map.get(key) == maxCount) answerLst.add(key);
                }
            }
        }
        
        // 4. 정렬
        Collections.sort(answerLst);
        
        // 5. 마지막 변환 
        String[] answer = new String[answerLst.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerLst.get(i);
        }
        
        return answer;
    }
    
    
    // 현재 주어진 문자열, 만들어진 조합, 탐색 시작 인덱스, 목표 길이
    // ex. DFS(sortedString, "", 0, c);
    public void DFS(String str, String comb, int start, int len) {
        
        // 공백이 아니라면 set에 추가 
        if ( comb.length() == len ) {
            map.put(comb, map.getOrDefault(comb, 0) + 1);
            return;
        }
        
        for(int i = start; i < str.length(); i++) {
            DFS(str, comb + str.charAt(i), i+1, len);
        }
    }
}