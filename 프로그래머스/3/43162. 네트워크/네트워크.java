import java.util.*;

class Solution {
    static List<Integer>[] arrLst;
    static boolean[] visited;
    static int count = 0;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        // 1. 인접 연결리스트 생성 
        arrLst = new ArrayList[n];
        for(int i = 0; i < arrLst.length; i++) {
            arrLst[i] = new ArrayList<>();
        }
        
        // 2. 인접 연결리스트 연결 
        for(int i = 0; i < computers.length; i++) {
            for(int j = 0; j < computers[i].length; j++) {
                if(computers[i][j] == 1) {
                    arrLst[i].add(j); 
                }
            }
        }
        
        // 모든 노드 순회하면서 DFS
        for(int i = 0; i < n; i++) {
            if( !visited[i] ) {
                count++;
                DFS(i);
            }
        }
        return count;
    }
    
    public void DFS(int node) {
        // 해당 노드에 들어옴 -> 방문 표시 
        visited[node] = true;
        
        // 연결된 지점들 DFS
        for(int a : arrLst[node]) {
            if( !visited[a] ) DFS(a);
        }
    }
}