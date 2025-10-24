import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        // 트럭 큐
        Queue<Integer> truck = new LinkedList<>();
        // 다리 큐
        Queue<Integer> bridge = new LinkedList<>();
        
        // 1. 트럭 큐에 트럭 넣기
        for(int i = 0; i < truck_weights.length; i++) {
            truck.offer(truck_weights[i]);
        }
        
        // 2. 다리 큐에 값 채워넣기
        for(int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        int truckSum = 0;
        // 3. 시간의 흐름에 따라 트럭을 다리에 올리고 -> 건너기 
        while(!truck.isEmpty()) {
            answer ++;
            
            // 3-1. 트럭 다리에 내리기
            int exited = bridge.poll();
            truckSum -= exited;
            
            // 3-2. 트럭 다리에 올리기 
            // 무게가 된다면 
            if(truckSum + truck.peek() <= weight) {
                int entering = truck.poll();
                truckSum += entering;
                bridge.offer(entering);
            }
            // 무게가 되지 않는다면 
            else {
                bridge.offer(0);
            }
            
        }
        return answer + bridge_length;
    }
}