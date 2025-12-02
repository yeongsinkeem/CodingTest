import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int n = topping.length; 
        
        // 1. 자르는 지점 별로 토핑 개수 저장하기 
        int[] aArr = new int[n];
        for(int i = 0; i < n; i++) {
            set.add(topping[i]);
            aArr[i] = set.size();
        }
        set.clear();
        
        
        int[] bArr = new int[n];
        for(int i = n-1; i >= 0; i--) {
            set.add(topping[i]);
            bArr[i] = set.size();
        }
        
        for(int i = 1; i < aArr.length; i++) {
            // 비교할 때는 0~i-1, i~끝까지 이런식으로 비교해야 함
            int aKinds = aArr[i-1];
            int bKinds = bArr[i];
            if( aKinds == bKinds ) answer++;
        }
        return answer;
    }
}