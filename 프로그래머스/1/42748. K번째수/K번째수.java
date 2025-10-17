import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int start = 0;
        int end = 0;
        int target = 0;
        
        // 1. array 배열 분리
        for(int i = 0; i < commands.length; i++) {
            start = commands[i][0]; // 2 
            end = commands[i][1];
            int[] splited = new int[end - start + 1];
            
            int startIdx = commands[i][0] - 1;
            for(int j = 0; j < end - start + 1; j++) {
                splited[j] = array[startIdx];
                startIdx = startIdx + 1;
            }
            
            // 2. 정렬
            Arrays.sort(splited);
            
            // 3. 원소 정답 배열에 추가
            target = commands[i][2] - 1;
            answer[i] = splited[target];
            
        }
        return answer;
    }
}