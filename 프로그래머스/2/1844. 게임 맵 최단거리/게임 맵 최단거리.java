import java.util.*;

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    int[][] maps;
    boolean[][] visited;
    // 좌표 넣을 큐
    Queue<int[]> q = new LinkedList<>();
    
    int n;
    int m;
    
    public int solution(int[][] maps) {
        int answer = 0;
        this.maps = maps;
        
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        
        // 1. 좌표 넣어주기 
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        BFS();
        
        if( maps[n-1][m-1] <= 1 ) return -1;
        
        return maps[n-1][m-1];
    }
    
    public void BFS() {
        while( !q.isEmpty() ) {
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];
            
            // 동서남북 탐색
            for( int i = 0; i < 4; i++ ) {
                int newX = currX + dx[i];
                int newY = currY + dy[i];
                
                // 1. 해당 좌표는 maps 경계 안에 존재할 것
                if( newX < 0 || newY < 0 || newX >= n || newY >= m ) continue;
                
                // 2. 해당 좌표는 미방문일 것
                if( visited[newX][newY] ) continue;
                
                // 3. 벽으로 막혀있지 않다면
                if( maps[newX][newY] == 1 ) {
                    maps[newX][newY] = maps[currX][currY] + 1;
                    visited[newX][newY] = true;
                    
                    q.offer(new int[]{newX, newY});
                }
            }
        }
    }
}