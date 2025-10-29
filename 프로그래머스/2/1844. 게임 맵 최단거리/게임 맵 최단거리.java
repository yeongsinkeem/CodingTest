import java.util.*;

class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        // BFS 
        // 1. 큐에 시작 좌표 넣기
        queue.offer(new int[]{0, 0});
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            
            // 1. 동서남북 탐색 
            for(int i = 0; i < 4; i++) {
                int newX = currX + dx[i];
                int newY = currY + dy[i];
                
                // 2. maps 경계 벗어난다면
                if (newX < 0 || newY < 0 || newX > n - 1 || newY > m - 1) continue;
                
                // 3. 벽으로 막혀 있다면 
                if (maps[newX][newY] == 0) continue;
                
                // 4. 미방문 좌표라면 : maps 상에서 값이 0 또는 1일 것
                // 하드 코딩 어떻게 ? 
                if (maps[newX][newY] < 2) {
                    // 값 업데이트
                    // 이전 좌표 + 1
                    maps[newX][newY] = maps[currX][currY] + 1;
                    // 큐에 값 넣기 
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        
        if( maps[n-1][m-1] < 2 ) return -1;
        
        return maps[n-1][m-1];
    }
}