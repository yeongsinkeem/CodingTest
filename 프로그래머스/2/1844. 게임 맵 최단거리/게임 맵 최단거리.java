import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        // int answer = 0;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int n = maps.length;
        int m = maps[0].length; 
        
        // 1. 좌표 Queue 준비 
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        
        while( !q.isEmpty() ) {
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];
            
            for(int i = 0; i < 4; i++) {
                int newX = currX + dx[i];
                int newY = currY + dy[i];
                
                // maps 내부에 존재 
                if( newX < 0 || newY < 0 || newX >= n || newY >= m ) continue;
                
                // 미방문 + 갈 수 있어야
                if( maps[newX][newY] == 1 ) {
                    q.offer(new int[] {newX, newY});
                    maps[newX][newY] = maps[currX][currY] + 1;
                }
            }
        }
        if( maps[n-1][m-1] > 1 ) return maps[n-1][m-1];
        else return -1;
        
        // return answer;
    }
}