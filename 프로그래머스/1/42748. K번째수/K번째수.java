import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        // 1. 기존 배열 자르기 
        for(int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            
            // end - start + 1 = 4
            int[] commArr = new int[end - start + 1];
            for(int j = 0; j < end - start + 1 ; j++) {
                commArr[j] = array[start - 1 + j];
            }
            Arrays.sort(commArr);
            
            answer[i] = commArr[commands[i][2] - 1];
        }
        
        return answer;
    }
}