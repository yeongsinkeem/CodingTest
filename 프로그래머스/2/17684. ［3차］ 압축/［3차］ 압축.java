import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        // 1. 사전 초기화 
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < 26; i++) {
            map.put( ((char)('A' + i) + ""), i + 1 );
        }
        
        List<Integer> answerLst = new ArrayList<>();
        int dictIdx = 27;
        
        // 2. msg 순회하면서
        for(int i = 0; i < msg.length(); i++) {
            String w = msg.charAt(i) + "";
            
            // 3. 다음 글자 붙인게 사전에 있다면 -> 다음 글자 붙이기 
            while( i + 1 < msg.length() && map.containsKey(w + msg.charAt(i + 1)) ) { 
                w += msg.charAt(i+1);
                i++; // 인덱스 증가 
            }
            // 4. 사전에 없다면 출력
            answerLst.add(map.get(w));
            
            
            // 5. 다음 글자가 남아있다면 등록
            if( i + 1 < msg.length() ) {
                String c = msg.charAt(i + 1) + "";
                map.put( w + c, dictIdx++ );
            }
        }
        
        // 6. 마지막 출력
        int[] answer = new int[answerLst.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerLst.get(i);
        }
        return answer;
    }
}