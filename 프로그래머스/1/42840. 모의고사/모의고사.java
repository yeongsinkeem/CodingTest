import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};                     // 5
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};            // 8
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};      // 10
        
        ArrayList<Integer> aTest = new ArrayList<>();
        ArrayList<Integer> bTest = new ArrayList<>();
        ArrayList<Integer> cTest = new ArrayList<>();
        
        // 1. 시험지 생성 
        for(int i = 0; i < answers.length; i++) {
            aTest.add( a[ i % 5 ] );
        }
        for(int i = 0; i < answers.length; i++) {
            bTest.add( b[ i % 8 ] );
        }
        for(int i = 0; i < answers.length; i++) {
            cTest.add( c[ i % 10 ] );
        }
        
        // 2. 정답 채점
        int aScore = 0;
        int bScore = 0;
        int cScore = 0;
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == aTest.get(i)) aScore++;
            if(answers[i] == bTest.get(i)) bScore++;
            if(answers[i] == cTest.get(i)) cScore++;
        }
        
        // 3. 최고 득점자 리턴 
        ArrayList<Integer> arr = new ArrayList<>();
        int max = Math.max(aScore, Math.max(bScore, cScore));
        
        if( max == aScore ) arr.add(1);
        if( max == bScore ) arr.add(2);
        if( max == cScore ) arr.add(3);
        
        int[] answer = new int[arr.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}