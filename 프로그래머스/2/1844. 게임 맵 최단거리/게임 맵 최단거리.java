import java.util.*;

class Solution {
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        // int answer = 1;
        int n = maps.length;
        int m = maps[0].length;
        
        // q = 이동할(한) 좌표 넣을 거임 
        Queue<int[]> q = new LinkedList<>();
        
        // 방문 좌표 : 미방문(0), 방문(++1)
        int[][] visited = new int[n][m];
        
        // 1. BFS 시작 
        q.offer( new int[]{0, 0} );
        visited[0][0] = 1;
        
        while(!q.isEmpty()) {
            int[] currPos = q.poll();
            int currX = currPos[0];
            int currY = currPos[1];
            
            // 2. 동서남북 탐색 
            for(int i = 0; i < 4; i++) {
                int newX = currX + dx[i];
                int newY = currY + dy[i];
                
                // 3. 만약 좌표판 벗어난다면 
                if(newX < 0 || newY < 0 || newX >= n || newY >= m) 
                    continue;
                
                // 4. 만약 벽으로 막혀 있다면 
                if(maps[newX][newY] == 0) 
                    continue;
                
                // 5. 만약 미방문 좌표라면
                if(visited[newX][newY] == 0) {
                    // 이동할 수 있으니 큐에 좌표 넣어주기
                    q.offer(new int[]{newX, newY});
                    // 값 업데이트 
                    visited[newX][newY] = visited[currX][currY] + 1;
                }
            }
        }
        int answer = visited[n-1][m-1];
        
        return (answer == 0) ? -1 : answer;
    }
}