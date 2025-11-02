class Solution {
    boolean[] visited;
    int[][] dungeons;
    int count;
    int maxCount = 0;
    int k;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        this.dungeons = dungeons;
        this.k = k;
        visited = new boolean[dungeons.length];
        
        // 1. DFS 시작
        DFS(visited, 0);
        
        return maxCount;
    }
    
    public void DFS(boolean[] v, int count) {
        //  1. 종료조건
        if(maxCount <= count) {
            maxCount = count;
        }
        
        // 2. 미방문 노드 && 체력 조건 충족 
        // 반복문 동안 재귀 
        for(int i = 0; i < dungeons.length; i++) {
            if( !v[i] && check(k, dungeons[i][0]) ) {
                k -= dungeons[i][1];
                v[i] = true;
                
                DFS(v, count + 1);
                
                v[i] = false;
                k += dungeons[i][1];
            }
        }
    }
    
    public boolean check(int a, int b) {
        if( a >= b ) return true;
        else return false;
    }
}