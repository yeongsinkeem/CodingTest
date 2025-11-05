import java.util.*;

class Solution {
    final int EMPTY = 0;
    final int PATH = 1;
    final int WALL = -1;
    
    int[][] map = new int[102][102];
    int[][] dist = new int[102][102];
    
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
    
        // 1. 좌표 생성
        createMap(rectangle);
        
        // 2. BFS를 위한 초기화
        int startX = characterX * 2;
        int startY = characterY * 2;
        int targetX = itemX * 2;
        int targetY = itemY * 2;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        
        // 3. dist(방문) 배열 초기화 
        for(int i = 0; i < 102; i++) {
            for(int j = 0; j < 102; j++) {
                // 벽 또는 방문 불가
                if(map[i][j] != PATH) dist[i][j] = -1;
                // 방문 가능
                else dist[i][j] = -2;
            }
        }
        
        // 4. 시작점 설정 
        dist[startX][startY] = 1;
        
        while( !queue.isEmpty() ) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            
            // 5. 종료조건
            if( currX == targetX && currY == targetY ) 
                return (dist[currX][currY] - 1) / 2;
            
            for(int i = 0; i < 4; i++) {
                int newX = currX+ dx[i];
                int newY = currY + dy[i];
                
                // 1. rectangle 안에 좌표 있어야 함
                if(newX < 0 || newY < 0 || newX > 101 || newY > 101) continue;
                
                // 2. 갈 수 있어야 함
                if(map[newX][newY] == WALL) continue;
                
                // 3. 미방문이어야 함
                if(dist[newX][newY] == -2) {
                    dist[newX][newY] = dist[currX][currY] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return 0;
    }
    
    public void createMap(int[][] rectangle) {
        // 1. 각 사각형에 대해 모든 좌표 2배
        for(int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            
            for(int i = x1; i <= x2; i++) {
                for(int j = y1; j <= y2; j++) {
                    // 2. 벽의 내부인지 테두리인지 판별 
                    // WALL : 내부, PATH : 테두리
                    if( i > x1 && i < x2 && j > y1 && j < y2 ) {
                        map[i][j] = WALL;
                    }
                    // 이때 테두리가 다른 사각형의 내부가 아닌 경우에만 길
                    else {
                        if( map[i][j] != WALL ) {
                            map[i][j] = PATH;
                        }
                    }
                }
            }
        }
        
    }
}