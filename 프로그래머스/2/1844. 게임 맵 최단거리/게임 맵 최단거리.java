import java.util.*;

class Solution {
    static int currX = 0;
    static int currY = 0;

    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        int[] xDist = {-1, 1, 0, 0};
        int[] yDist = {0, 0, 1, -1};
        
        // 1. Queue 준비 및 시작점 추가
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        maps[0][0] = 0; // 재방문 방지 
        
        // 2. BFS 시작 
        while(!queue.isEmpty()) {
            // 3. 원소 빼기 
            int[] curr = queue.poll();
            
            int x = curr[0];
            int y = curr[1];
            int cost = curr[2];
            
            // 종료 조건 
            if( x == n-1 && y == m-1 ) {
                return cost;
            }
            
            // 4. 동서남북 탐색 
            for(int i = 0; i < 4; i++) {
                int newX = x + xDist[i];
                int newY = y + yDist[i];
                // 5. 이동 가능하다면 
                if( newX >= 0 && newY >= 0 && newX < n && newY < m) {
                    if( maps[newX][newY] == 1 ) {
                        maps[newX][newY] = 0;
                        queue.offer(new int[]{newX, newY, cost + 1});
                    }
                }
            }
        }
        return -1;
    }
}