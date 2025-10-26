// 15:16 ~ 15:46
import java.util.*;

class Solution {
    private static ArrayList<Integer>[] A;
    private static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // 1. 인접 배열 리스트 및 방문 배열 초기화 
        A = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            A[i] = new ArrayList<>();
        }
        visited = new boolean[n];
        
        // 2. 인접 배열 리스트 연결 
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(computers[i][j] == 1) {
                    A[i].add(j);
                }
            }
        }
        
        // 3. DFS 시작
        for(int i = 0; i < n; i++) {
            // 미방문 노드에 한해서 탐색 시작
            if( !visited[i] ) {
                answer++;
                DFS(i);
            }
        }
        
        return answer;
    }
    
    public void DFS(int node) {
        // 1. 종료조건 - 방문노드 
        if (visited[node] ) return;
        
        // 2. 방문 표시 
        visited[node] = true;
        
        // 3. 재귀 
        for( int newNode : A[node] ) {
            if( !visited[newNode] ) {
                DFS(newNode);
            }
        }
    }
}