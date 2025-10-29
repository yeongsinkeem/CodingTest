import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        if( k >= enemy.length ) return enemy.length;
        
        // 1. min-Heap인 PQ 생성 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 2. 순회하면서 일단 pq에 넣기
        for(int i = 0; i < enemy.length; i++) {
            pq.offer(enemy[i]);
            k--;
            
            // 3. 만약 무적권이 부족해진다면 
            if( k < 0 ) {
                // 가장 가성비가 좋지 않은 원소(최솟값 리턴)
                // 동시에 병사 수도 감소
                n -= pq.poll();
                k++;
            }
            
            // 4. 만약 남은 병사의 수 < 현재 라운드의 적의 수
            if( n < 0 ) {
                return i;
            }
        }
        
        return enemy.length;
    }
}