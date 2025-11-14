class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length - 1;
        
        // 맨마지막은 계산할 필요 x
        for( int i = len - 1; i >= 0; i-- ) {
            for( int j = 0; j <= triangle[i].length - 1; j++ ) {
                int left = triangle[i + 1][j];
                int right = triangle[i + 1][j + 1];
                
                triangle[i][j] = triangle[i][j] + Math.max(right, left);
                // System.out.println(triangle[i][j]);
            }
        }
        
        return triangle[0][0];
    }
}