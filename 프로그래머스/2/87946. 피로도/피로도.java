import java.util.*;

class Solution {
    boolean[] visited;
    int[][] dungeons;
    int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        visited = new boolean[dungeons.length];
        
        DFS(k, 0); // 시작 피로도와 방문 횟수 전달
        return max;
    }
    
    public void DFS(int k, int count) {
        // 현재 탐험 가능한 던전 수로 최대값 갱신
        max = Math.max(max, count);
        
        for (int i = 0; i < dungeons.length; i++) {
            int minNeed = dungeons[i][0];
            int consume = dungeons[i][1];
            
            // 아직 방문 안했고, 현재 피로도로 입장 가능할 때
            if (!visited[i] && k >= minNeed) {
                visited[i] = true;
                DFS(k - consume, count + 1); // 다음 탐색 (피로도 감소)
                visited[i] = false;           // 백트래킹
            }
        }
    }
}
