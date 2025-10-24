import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerArr = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        // 1. 작업 일수 큐 생성 
        int[] left = new int[progresses.length];
        int days = 0;
        
        for(int i = 0; i < left.length; i++) {
            int mod = (100 - progresses[i]) % speeds[i];
            if( mod != 0 ) {
                days = (100 - progresses[i]) / speeds[i] + 1;
            }
            else {
                days = (100 - progresses[i]) / speeds[i];
            }
            queue.add(days);
        }
        
        int count = 1;
        // 2. 큐 활용
        // 꺼낸 원소보다 작거나 같 vs 큰지 ?
        int n = queue.poll();
        while(!queue.isEmpty()) {
            if( n >= queue.peek() ) {
                count ++;
                queue.poll();
            }
            else {
                answerArr.add(count);
                count = 1;
                n = queue.poll();
            }
        }
        
        if(count >= 0) {
            answerArr.add(count);
        }
        
        int[] answer = new int[answerArr.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerArr.get(i);
        }
        
        return answer;
    }
}