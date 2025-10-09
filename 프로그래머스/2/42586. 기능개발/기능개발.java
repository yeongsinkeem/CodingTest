import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerArr = new ArrayList<>();

        int count = 1;
        
        // 1. 일자 계산 및 Queue 준비 
        int n = progresses.length;
        int day;
        int[] days = new int[n];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            // 이때 나머지가 있으면 + 1
            int left = (100-progresses[i]) % speeds[i];
            if(left > 0) {
                day = ((100 - progresses[i]) / speeds[i]) + 1;
            }
            else {
                day = (100 - progresses[i]) / speeds[i];
            }
            q.add(day);
        }
        
        // 2. 배포 
        int first = q.poll();
        while( !q.isEmpty() ) {
            int next = q.poll();
            if(first >= next) {
                count++;
            }
            else {
                first = next;
                answerArr.add(count);
                count = 1;
            }
        }
        
        answerArr.add(count);
        
        // 3. 리스트 -> 배열 변환 
        int[] answer = answerArr.stream()
                                .mapToInt(Integer::intValue)
                                .toArray();
        
        return answer;
    }
}