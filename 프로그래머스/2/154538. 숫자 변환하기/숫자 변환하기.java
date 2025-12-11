import java.util.*;

class Solution {
    static class Process {
        private int sum;
        private int round;
        
        public Process(int sum, int round) {
            this.sum = sum;
            this.round = round;
        }
    }
    
    public int solution(int x, int y, int n) {
        
        // 1. 큐 준비 
        Queue<Process> q = new LinkedList<>();
        q.offer(new Process(x, 0));
        
        // 2. 방문 배열 / set
        Set<Integer> set = new HashSet<>();
        
        while( !q.isEmpty() ) {
            Process curr = q.poll();
    
            int currSum = curr.sum;
            int currRound = curr.round;
            
            if( currSum == y ) return currRound; 
            
            for(int i = 1; i <= 3; i++) {
                if( i == 1 ) {
                    int newSum = currSum * 2;
                    if( newSum <= y && !set.contains(newSum)) {
                        q.offer(new Process(newSum, currRound + 1));
                        set.add(newSum);
                    }
                }
                else if( i == 2 ) {
                    int newSum = currSum * 3;
                    if( newSum <= y && !set.contains(newSum)) {
                        q.offer(new Process(newSum, currRound + 1));
                        set.add(newSum);
                    }
                }
                else if( i == 3 ) {
                    int newSum = currSum + n;
                    if( newSum <= y && !set.contains(newSum) ) {
                        q.offer(new Process(newSum, currRound + 1));
                        set.add(newSum);
                    }
                }
            }
        }
        
        return -1;
    }
}