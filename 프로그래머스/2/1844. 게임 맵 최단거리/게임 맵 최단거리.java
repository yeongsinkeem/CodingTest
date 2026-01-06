import java.util.*;

class Solution {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        // BFS
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        
        while( !q.isEmpty() ) {
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];
            
            // 1. 동서남북 탐색 
            for(int i = 0; i < 4; i++) {
                int newX = currX + dx[i];
                int newY = currY + dy[i];
                
                // 2. map의 경계 벗어나지 않고
                if( newX < 0 || newY < 0 || newX >= n || newY >= m ) continue;
                
                // 3. 벽이 아님 
                if( maps[newX][newY] == 0 ) continue;
                
                // 4. 방문했다면 값이 1보다 큼
                if( maps[newX][newY] > 1 ) continue;
                
                // 5. 모두 통과했다면 값 업데이트 
                maps[newX][newY] = maps[currX][currY] + 1;
                q.offer(new int[]{newX, newY});
            }
        }
        
        if( maps[n-1][m-1] == 1 ) return -1;
        
        return maps[n-1][m-1];
    }
}