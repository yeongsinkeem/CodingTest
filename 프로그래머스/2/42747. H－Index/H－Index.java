import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // 1. citations 정렬 정렬
        Arrays.sort(citations);
        
        // 2. 반복문 순회하면서 H-Index 구하기
        for( int i = 0; i < citations.length; i++ ) {
            int count = citations[i];
            int paper = citations.length - i;
            
            int hIndex = Math.min(count, paper);
            answer = Math.max(answer, hIndex);
            
        }
        return answer;
    }
}