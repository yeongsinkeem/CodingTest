import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(String dirs) {
        int sum = 0;
        
        int currX = 5;
        int currY = 5;
        
        // 방문 간선 관리
        Set<String> set = new HashSet<>();
        
        for( char c : dirs.toCharArray() ) {

            int newX = currX;
            int newY = currY;
            
            // 2. 동서남북 값 업데이트 
            if ( c == 'U' ) {
                newY += 1;
            }
            
            else if( c == 'D' ) {
                newY -= 1;
            }
            
            else if( c == 'L' ) {
                newX -= 1;
            }
            
            else if( c == 'R' ) {
                newX += 1;
            }
            
            // 3. 새로운 좌표 확인
            // 3-1. maps 경계 벗어나지 않을 것
            if( newX < 0 || newX > 10 || newY < 0 || newY > 10 ) continue;
            
            // 3-2. 미방문 간선일 것
            String path;
            
            if( newX < currX || ( newX == currX && newY < currY ) ) {
                path = "" + newX + newY + currX + currY;
            }
            else {
                path = "" + currX + currY + newX + newY;
            }
            
            if( !set.contains(path) ) {
                set.add(path);
                sum++;
            }
            
            // 4. 좌표 업데이트
            currX = newX;
            currY = newY;
        }
        
        return sum;
    }
}