import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        // 1. 다리 큐
        Queue<Integer> bridgeQ = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++) {
            bridgeQ.offer(0);
        }
        
        // 2. 대기 큐
        Queue<Integer> waitQ = new LinkedList<>();
        for(int i = 0; i < truck_weights.length; i++) {
            waitQ.offer(truck_weights[i]);
        }
        
        // 3. 초기 설정 
        int completed = 0;
        int time = 0;
        int sum = 0;
        
        // 3. 모든 트럭이 다 지나갈 때까지
        while(completed < truck_weights.length) {
            time ++;
            
            // 4. 트럭(혹은 0) 나옴
            int item = bridgeQ.poll();
            
            // 5. 실제 나온게 트럭이라면
            if(item != 0) {
                sum -= item;
                completed++;
            }
            
            // 6. 트럭 다리에 올리기
            if( !waitQ.isEmpty() ) {
                // 7. 다리에 올라갈 수 있는 경우
                if( sum + waitQ.peek() <= weight ) {
                    int leaving = waitQ.poll();
                    sum += leaving;
                    bridgeQ.offer(leaving);
                } 
                
                // 8. 다리에 올라갈 수 없는 경우 
                else {
                    bridgeQ.offer(0);
                }
            } 
            // 대기 트럭이 없어도 트럭은 다리 지나가야 함
            else {
                bridgeQ.offer(0);
            }
        }
        
        return time;
    }
}