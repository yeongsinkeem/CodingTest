class Solution {
    
    public int[] solution(int n) {
        int totalSize = n * (n+1) / 2;
        int[][] matrix = new int[n][n];
        
        int start = 1;
        int row = -1;
        int col = 0;
        
        for(int i = 0; i < n; i++) {
            // 처음엔 n칸
            // 그다음엔 n-1칸
            // 그다음엔 n-2칸 갈 수 있음 
            int len = n - i;
            
            for(int j = 0; j < len; j++) {
                // 아래
                if( i % 3 == 0 ) {
                    row++;
                }
                // 오른쪽
                else if( i % 3 == 1 ) {
                    col++;
                }
                // 대각선 
                else {
                    row--;
                    col--;
                }
                
                matrix[row][col] = start;
                start++;
            }
        }
        
        int[] answer = new int[totalSize];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                answer[idx] = matrix[i][j];
                idx++;
            }
        }
        
        return answer;
    }
}