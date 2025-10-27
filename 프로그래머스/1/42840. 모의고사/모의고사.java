import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int n = answers.length;
        
        // 1. 시험지 생성
        int[] aTest = {1, 2, 3, 4, 5};
        int[] aAnswer = new int[n];
        for(int i = 0; i < n; i++) {
            aAnswer[i] = aTest[i % 5];
        }
        
        int[] bTest = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] bAnswer = new int[n];
        for(int i = 0; i < n; i++) {
            bAnswer[i] = bTest[i % 8];
        }
        
        int[] cTest = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] cAnswer = new int[n];
        for(int i = 0; i < n; i++) {
            cAnswer[i] = cTest[i % 10];
        }
        
        // 2. 채점
        int aScore = 0;
        int bScore = 0;
        int cScore = 0;
        
        for(int i = 0; i < n; i++) {
            if(aAnswer[i] == answers[i]) aScore++;
            if(bAnswer[i] == answers[i]) bScore++;
            if(cAnswer[i] == answers[i]) cScore++;
        }
        
        // 3. 최댓값
        int maxScore = Math.max(aScore, Math.max(bScore, cScore));
        
        ArrayList<Integer> lst = new ArrayList<>();
        if(maxScore == aScore) lst.add(1);
        if(maxScore == bScore) lst.add(2);
        if(maxScore == cScore) lst.add(3);
        
        int[] answer = new int[lst.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = lst.get(i);
        }
        return answer;
    }
}