class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int minX = 50;
        int minY = 50;
        int maxX = 0;
        int maxY = 0;
        
        int row = wallpaper.length;
        int col = wallpaper[0].length();
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if( wallpaper[i].charAt(j) == '#' ) {
                    if( i <= minX ) minX = i;
                    if( j <= minY ) minY = j;
                    if( i >= maxX ) maxX = i;
                    if( j >= maxY ) maxY = j;
                }
            }
        }
        maxX += 1;
        maxY += 1;
        
        answer[0] = minX;
        answer[1] = minY;
        answer[2] = maxX;
        answer[3] = maxY;
        return answer;
    }
}