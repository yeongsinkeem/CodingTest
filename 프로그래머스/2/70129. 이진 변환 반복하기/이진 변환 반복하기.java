import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        if( s.equals("1") ) {
            answer[0] = 0;
            answer[1] = 0;
            
            return answer;
        }
        
        int zeroCnt = 0;
        int round = 0;
        
        while( !s.equals("1") ) {
            round += 1;
            int oneCnt = 0;
            
            // 1. 0 없애기 
            for(int i = 0; i < s.length(); i++) {
                if( s.charAt(i) == '1' ) {
                    oneCnt += 1;
                }
                else {
                    zeroCnt += 1;
                }
            }
            
            // 2. 이진수로 변환 
            s = Integer.toBinaryString(oneCnt);
        }
        
        answer[0] = round;
        answer[1] = zeroCnt;
        
        return answer;
    }
}