import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int[] hIndex = new int[citations.length];
        
        // 1. citations 내림차순 정렬
        Arrays.sort(citations);
        
        // 2. 반복문 순회하면서 H-Index 구하기
        for( int i = 0; i < citations.length; i++ ) {
            int count = citations[i];
            int paper = citations.length - i;
            
            if( count <= paper ) {
                hIndex[i] = count;
            }
            else {
                hIndex[i] = paper;
            }
            
            System.out.println(i + "번째 H_Index: " + hIndex[i]);
        }
        // 3. hIndex 정렬
        Arrays.sort(hIndex);
        answer = hIndex[hIndex.length-1];
        
        return answer;
    }
}