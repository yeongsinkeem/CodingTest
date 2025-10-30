import java.util.*;

class Solution {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int a = computers.length;
        int b = computers[0].length;
        
        // 1. 인접 배열 리스트 초기화 + visited
        arr = new ArrayList[a];
        visited = new boolean[a];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }
        
        // 2. 인접 배열 리스트 연결 
        for(int i = 0; i < a; i++) {
            for(int j = 0; j < b; j++) {
                if(computers[i][j] == 1) {
                    arr[i].add(j);
                }
            }
        }
        
        // 3. 노드 탐색하며 DFS 
        for(int i = 0; i < n; i++) {
            // 미방문 노드라면 
            if( !visited[i] ) {
                answer++;
                // DFS
                DFS(i);
            }
        }
        return answer;
    }
    
    public void DFS(int i) {
        if( visited[i] ) return;
        
        visited[i] = true;
            
        // 연결된 노드들에 한하여 DFS 시작
        for(int a : arr[i]) {
            if( !visited[a] ) 
                DFS(a);
        }
    }
}