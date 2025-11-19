import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answerLst = new ArrayList<>();
        
        // 1. 길이가 1인 모든 단어 포함하도록 사전 초기화
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < 26; i++) {
            map.put( ((char)('A' + i)) + "", i + 1);
        }
        
        int idx = 27;
        
        for(int i = 0; i < msg.length(); i++) {
            String w = msg.charAt(i) + "";
            
            // 2. 붙인 문자열 map에 존재하는지, 안 하는지 확인
            // 계속 붙여야 하기 때문
            while( i + 1 < msg.length() && map.containsKey(w + msg.charAt(i+1) + "" ) ) {
                w += msg.charAt(i+1) + "";
                i ++;
            }
            
            // 3. 붙인 게 없다면 출력
            answerLst.add(map.get(w));
            
            // 4. 새로운 문자열 등록 
            if( i + 1 < msg.length() ) {
                map.put( w + (msg.charAt(i+1) + ""), idx++ );
            }
        }
        
        int[] answer = new int[answerLst.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerLst.get(i);
        }
        
        
        return answer;
    }
}