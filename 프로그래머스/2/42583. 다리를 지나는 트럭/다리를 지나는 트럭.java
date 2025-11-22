import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        // 1. bridge_length 만큼 0으로 된 큐 만들기
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++) {
            q.offer(0);
        }
        
        int idx = 0;
        int currWeights = 0;
        // 2. 트럭이 다 올라갈 때까지 
        while ( idx < truck_weights.length ) {
            answer += 1;
            
            int exited = q.poll();
            currWeights -= exited;
            
            // 3. 새로운 트럭 올릴 수 있다면 
            if( currWeights + truck_weights[idx] <= weight ) {
                q.offer(truck_weights[idx]);
                currWeights += truck_weights[idx];
                idx += 1;
            }
            
            else {
                q.offer(0);
            }
        }
        
        return answer + bridge_length;
    }
}