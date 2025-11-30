import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int len = elements.length;
        Set<Integer> set = new HashSet<>();
        
        // 1. 총 길이 : 1 ~ len
        for(int l = 1; l <= len; l++) {
            // 2. 시작 인덱스
            for(int i = 0; i < len; i++) {
                int currSum = 0;
                // 3. 길이 l인 연속 부분 수열에 원소 더하기
                for(int j = 0; j < l; j++) {
                    int idx = (i + j) % len;
                    currSum += elements[idx];
                }
                set.add(currSum);
            }
        }
        answer = set.size();
        
        return answer;
    }
}