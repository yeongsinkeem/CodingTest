class Solution {
    static int count = 0;
    static boolean[] v;
    static int curr;
    static int[][] dungeons;
    
    public int solution(int k, int[][] dungeons) {
        curr = 0; // 현재 몇 개의 스테이지 탐험했는지 
        this.dungeons = dungeons;
        
        // 1. DFS + 완전 탐색 시작 
        v = new boolean[dungeons.length];
        
        DFS(k, curr);
        
        return count;
    }
    
    // 현재의 피로도, 던전 수 
    public void DFS(int k, int curr) {  
        count = Math.max(count, curr);
        
        for(int i = 0; i < dungeons.length; i++) {
            // 미방문 + 현재 피로도로 갈 수 있다면 
            if( !v[i] && k >= dungeons[i][0] ) {
                k = k - dungeons[i][1];
                v[i] = true; 
                
                DFS(k, curr + 1);
                
                k += dungeons[i][1];
                v[i] = false;
            }
        }
    }
}