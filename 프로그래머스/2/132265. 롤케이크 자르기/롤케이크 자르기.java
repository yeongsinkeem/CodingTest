import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int len = topping.length;
        if( len < 2 ) return 0;
        
        Set<Integer> set = new HashSet<>();
        
        // 1. 철수의 토핑 종류 세기. 0 ~ len - 1
        int[] aLst = new int[len];
        for(int i = 0; i < len; i++) {
            set.add(topping[i]);
            aLst[i] = set.size();
        }
        set.clear();
        
        // 2. 동생의 토핑 종류 세기. len - 1 ~ 0 
        int[] bLst = new int[len];
        for(int i = len - 1; i >= 0; i--) {
            set.add(topping[i]);
            bLst[i] = set.size();
        }
        
        // 3. 자르는 지점을 기준으로 종류 수 비교
        for(int i = 1; i < len; i++) {
            int aKinds = aLst[i-1];
            int bKinds = bLst[i];
            
            if( aKinds == bKinds ) answer++;
        }
        
        
        return answer;
    }
}