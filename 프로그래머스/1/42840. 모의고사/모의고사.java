import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answerArr = new ArrayList<>();
        
        int ansLen = answers.length;
        
        // 1. 시험지 생성
        int[] test1 = new int[ansLen];
        int[] test2 = new int[ansLen];
        int[] test3 = new int[ansLen];
        
        int[] a1Arr = {1, 2, 3, 4, 5};
        for(int i = 0; i < ansLen; i++) {
            test1[i] = a1Arr[i % 5];
        }
        
        int[] a2Arr = {2, 1, 2, 3, 2, 4, 2, 5};
        for(int i = 0; i < ansLen; i++) {
            test2[i] = a2Arr[i % 8];
        }
        
        int[] a3Arr = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for(int i = 0; i < ansLen; i++) {
            test3[i] = a3Arr[i % 10];
        }
        
        // 2. 시험지 채점 
        int[] count = new int[3];
        for(int i = 0; i < ansLen; i++) {
            if(test1[i] == answers[i]) count[0]++;
            if(test2[i] == answers[i]) count[1]++;
            if(test3[i] == answers[i]) count[2]++;
        }
        
        // 3. 시험지 점수 비교 
        // 값 3개 비교 
        int maxScore = Math.max(count[0], Math.max(count[1], count[2]));
        
        if(maxScore == count[0]) answerArr.add(1);
        if(maxScore == count[1]) answerArr.add(2);
        if(maxScore == count[2]) answerArr.add(3);
        
        // 4. 리스트 -> 배열 변환 
        int[] answer = new int[answerArr.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerArr.get(i);
        }
        
        return answer;
    }
}