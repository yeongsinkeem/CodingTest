import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        
        long sum1 = 0;
        long sum2 = 0;
        for(int i = 0; i < queue1.length; i++) {
            q1.offer((long)queue1[i]);
            q2.offer((long)queue2[i]); 
            
            sum1 += (long)queue1[i];
            sum2 += (long)queue2[i];
        }
        
        int cnt = 0;
        int limit = q1.size() * 4;
        while( cnt <= limit ) {
            // 1. 평균보다 더 큰 큐가 작은 큐에게 원소 주기 
            if( sum1 == sum2 ) {
                return cnt;
            }
            
            else if( sum2 < sum1 && q1.size() > 0 ) {
                long num = q1.poll();
                q2.offer(num);
                cnt++;
                
                sum2 += num;
                sum1 -= num;
            }
            
            else if( sum1 < sum2 && q2.size() > 0 ){
                long num = q2.poll();
                q1.offer(num);
                cnt++;
                
                sum1 += num;
                sum2 -= num;
            }
        }
        
        return -1;
    }
}