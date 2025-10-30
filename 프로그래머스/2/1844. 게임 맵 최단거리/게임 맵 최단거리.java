import java.util.*;

class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        // 좌표가 들어갈 큐 + 방문 배열
        Queue<int[]> queue = new LinkedList<>();
        // int[] visited = new int[n * m];
        
        // 1. 시작좌표(0, 0) Queue에 넣어주기
        queue.offer(new int[]{0, 0});
        
        while( !queue.isEmpty() ) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            
            for(int i = 0; i < 4; i++) {
                int newX = currX + dx[i];
                int newY = currY + dy[i];
                
                // 2. maps 경계 벗어난다면 > 탈출
                if( newX < 0 || newY < 0 || newX >= n || newY >= m )
                    continue;
                
                // 3. 막혀있다면 > 탈출 
                if( maps[newX][newY] == 0 )
                    continue;
                
                // 4. 미방문 좌표라면 
                if( maps[newX][newY] <= 1 ) {
                    maps[newX][newY] = maps[currX][currY] + 1;  
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        
        if( maps[n-1][m-1] == 1 ) return -1;
        
        return maps[n-1][m-1];
    }
}