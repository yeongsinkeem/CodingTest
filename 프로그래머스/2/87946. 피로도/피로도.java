class Solution {
    static int maxCnt = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] v = new boolean[dungeons.length];
        
        // DFS 시작
        DFS(k, v, 0, dungeons);
        
        return maxCnt;
    }
    
    // 현재 체력, 방문배열, 현재 노드 깊이, 던전 몇 개 ? 
    public void DFS(int curr, boolean[] v, int cnt, int[][] dungeons) {
        maxCnt = Math.max(maxCnt, cnt);
        
        // 1. 던전 DFS
        for(int i = 0; i < dungeons.length; i++) {
            // 2. 미방문 던전 && 최소 피로도 충족에 대해서 DFS
            if( !v[i] && curr >= dungeons[i][0] ) {
                v[i] = true;
                DFS(curr - dungeons[i][1], v, cnt + 1, dungeons);
                v[i] = false;
            }
        }
    }
}