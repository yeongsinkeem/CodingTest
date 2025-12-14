class Solution {
    private int[] answer;
    
    public int[] solution(int[][] arr) {
        answer = new int[2];
        
        quadCompress(arr, 0, 0, arr.length);
        
        return answer;
    }
    
    public void quadCompress(int[][] arr, int r, int c, int size) {
        
        // 1. 모두 같은 수라면 -> 해당 값으로 압축
        if( isCompressible(arr, r, c, size) ) {
            int value = arr[r][c];
            answer[value]++;
            return;
        }
        
        // 2. 그게 아니라면 재귀로 영역 쪼개기
        int halfSize = size / 2;
        
        quadCompress(arr, r, c, halfSize);
        quadCompress(arr, r + halfSize, c, halfSize);
        quadCompress(arr, r, c + halfSize, halfSize);
        quadCompress(arr, r + halfSize, c + halfSize, halfSize);
    }
    
    
    public boolean isCompressible(int[][] arr, int r, int c, int size) {
        int standard = arr[r][c];
        
        for(int i = r; i < r + size; i++) {
            for(int j = c; j < c + size; j++) {
                if( arr[i][j] != standard ) return false;
            }
        }
        
        return true;
    }
}