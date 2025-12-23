import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int seconds = 0;
        int limit = 0;
        
        // 대기 큐
        Queue<Integer> wq = new LinkedList<>();
        for(int t : truck_weights){
            wq.offer(t);
        }
        
        // 다리 큐
        Queue<Integer> bq = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++) {
            bq.offer(0);
        }
        
        while( !wq.isEmpty() ) {
            seconds ++;
            limit -= bq.poll();
                
            // 트럭 더 올릴 수 있다면 
            if( !wq.isEmpty() && limit + wq.peek() <= weight ) {
                int truck = wq.poll();
                
                bq.offer(truck);
                limit += truck;
            }
            
            // 더 올릴 수 없다면 -> 0으로 채우기 
            else {
                bq.offer(0);
            }
        }

        return seconds + bridge_length;
    }
}