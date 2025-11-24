class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int n = board.length;
        
        // board[h][w]의 같은 색
        String currColor = board[h][w];
        int[] currPos = new int[]{h, w};
        
        for(int d = 0; d < 4; d++) {
            int newX = currPos[0] + dx[d];
            int newY = currPos[1] + dy[d];
            
            if( newX < 0 || newY < 0 || newX >= board.length || newY >= n ) 
                continue;
            
            // 만약 해당 색깔이 동일하면 
            String newColor = board[newX][newY];
            if( currColor.equals(newColor) ) {
                // System.out.println(newX + ", " + newY);
                answer++;
            }
        }
        
        
        // 1. board 순회하면서
        /*
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int currCount = 0;
                
                String currColor = board[i][j];
                int[] currPos = new int[]{i, j};
                
                // 2. 동서남북 탐색 
                for(int d = 0; d < 4; d++) {
                    int newX = currPos[0] + dx[d];
                    int newY = currPos[1] + dy[d];
                    
                    // 이때 board 경계 벗어나지 말 것
                    if( newX < 0 || newY < 0 || newX >= board.length || newY >= n ) continue;
                    
                    // 만약 해당 색깔이 동일하면 
                    String newColor = board[newX][newY];
                    if( currColor.equals(newColor) ) {
                        System.out.println(newX + ", " + newY);
                        currCount++;
                    }
                }
                
                
                // 3. 탐색 후 count 값 업데이트
                if( currCount > count ) {
                    h = j;
                    w = i;
                    count = currCount;
                }
            }
        }
        */
        
        return answer;
    }
}