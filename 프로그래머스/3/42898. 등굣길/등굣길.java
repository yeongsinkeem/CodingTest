class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dp = new int[n+1][m+1];
        boolean[][] block = new boolean[n+1][m+1];
        
        // 1. 물웅덩이 표시
        for(int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];
            
            block[y][x] = true;
        }
        
        dp[1][1] = 1;
        // 2. dp 채우기 
        // dp[i][j] = dp[i-1][j] + dp[i][j-1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                // 시작점 x
                if( i == 1 && j == 1 ) continue;
    
                // 물웅덩이 x
                if( !block[i][j] ) {
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
                }
            }
        }

        return dp[n][m];
    }
}