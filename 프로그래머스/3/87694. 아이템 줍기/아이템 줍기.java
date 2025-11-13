import java.util.*;

class Solution {
    int[][] maps = new int[102][102];
    int[][] visited = new int[102][102];
    
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    final int PATH = 1;
    final int WALL = 2;
    final int EMPTY = -1;
    
    public void createMap(int[][] rectangle) {
            for(int[] rec : rectangle) {
                int startX = rec[0] * 2;
                int startY = rec[1] * 2;
                int endX = rec[2] * 2;
                int endY = rec[3] * 2;
                
                for(int a = startX; a <= endX; a++) {
                    for(int b = startY; b <= endY; b++) {
                        // 이렇게 되면 경계면도 PATH가 됨 -> 따라서 WALL 처리 다시 
                        if( a == startX || a == endX || b == startY || b == endY ) {
                            maps[a][b] = PATH; 
                        }
                    }
                }
            }
        
            for(int[] rec : rectangle) {
                int startX = rec[0] * 2;
                int startY = rec[1] * 2;
                int endX = rec[2] * 2;
                int endY = rec[3] * 2;
                
                for(int a = startX; a <= endX; a++) {
                    for(int b = startY; b <= endY; b++) {
                        // 이렇게 되면 경계면도 PATH가 됨 -> 따라서 WALL 처리 다시 
                        if( a > startX && a < endX && b > startY && b < endY ) {
                            maps[a][b] = WALL; 
                    }
                }
            }
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 1. 지도 그리기
        createMap(rectangle);
        
        // 2. 변수 준비
        int cX = characterX * 2;
        int cY = characterY * 2;
        int iX = itemX * 2;
        int iY = itemY * 2;
        
        // 3. BFS 준비
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < 102; i++) {
            for(int j = 0; j < 102; j++) {
                visited[i][j] = 0;
            }
        }
        
        queue.offer( new int[]{cX, cY} );
        
        // 4. 시작점은 1로 표시 
        visited[cX][cY] = 1;
        
        // 5. BFS 시작
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            
            if(currX == iX && currY == iY) return (visited[currX][currY] - 1) / 2;
            
            for(int i = 0; i < 4; i++) {
                int newX = curr[0] + dx[i];
                int newY = curr[1] + dy[i];
                
                // 미방문 + PATH + maps에 존재 
                if( newX > 0 && newX < 102 && newY > 0 && newY < 102 ) {
                    if( maps[newX][newY] == PATH && visited[newX][newY] == 0 ) {
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = visited[currX][currY] + 1;
                    }
                }
            }
        }
        
        return 0;
    }
}