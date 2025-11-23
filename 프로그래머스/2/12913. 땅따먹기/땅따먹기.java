class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        int N = land.length;
        
        // 두번째 행부터 시작
        for(int row = 1; row < N; row++) {
            for(int col = 0; col < 4; col++) {
                int maxPrevScore = 0;
                
                // 1. 이전 행의 누적 점수 갱신
                for(int prevC = 0; prevC < 4; prevC++) {
                    if( col != prevC ) {
                        maxPrevScore = Math.max(maxPrevScore, land[row-1][prevC]);
                    }
                }
                // 2. 현재 행에 누적
                land[row][col] += maxPrevScore;
            }
        }
        
        // land[N-1][0] : 0열로 끝났을 때 최대 누적 점수
        // land[N-1][1] : 1열로 끝났을 때 최대 누적 점수
        int maxTotalScore = 0;
        for(int score : land[N-1]) {
            maxTotalScore = Math.max(score, maxTotalScore);
        }
        
        return maxTotalScore;
    }
}