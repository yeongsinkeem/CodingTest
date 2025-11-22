import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerLst = new ArrayList<>();
        
        // 1. progresses - speeds 순회하면서 days 배열 만들기
        int[] days = new int[progresses.length];
        
        // 2. 날짜 계산
        for(int i = 0; i < progresses.length ; i++) {
            // 나머지가 있다면 -> 올림 
            int timeLeft = (100 - progresses[i]) / speeds[i];
            
            if( (100 - progresses[i]) % speeds[i] != 0 ) timeLeft ++;

            days[i] = timeLeft;
        }
        
        // 3. Queue 준비
        Queue<Integer> q = new LinkedList<>();
        
        // 4. days 순회하면서 현재 요소가 q보다 작거나 같으면 q에 넣기
        for(int d : days) {
            if( q.isEmpty() || d <= q.peek() ) {
                q.offer(d);
            }
            
            // 현재 요소가 q보다 크다면 -> 배포해야 함 
            else if( q.peek() < d ) {
                answerLst.add(q.size());
                q.clear();
                q.offer(d);
            }
        }
        
        // 5. 큐가 비어있지 않다면 
        if( !q.isEmpty() ) {
            answerLst.add(q.size());
        }
        
        // 6. list -> 배열로 변환
        int[] answer = new int[answerLst.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerLst.get(i);
        }

        return answer;
    }
}