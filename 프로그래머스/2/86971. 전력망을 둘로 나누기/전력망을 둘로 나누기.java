import java.util.*;

class Solution {
    boolean[] v;
    int count;
    int minCount = Integer.MAX_VALUE;
    ArrayList<Integer>[] arr;
    
    public int solution(int n, int[][] wires) {
        // 1. 인접연결리스트 및 방문 배열 생성 
        arr = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for(int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            arr[a].add(b);
            arr[b].add(a);
        }
        // v = new boolean[n + 1];
        
        // 2. DFS + 완전탐색 시작 
        // 이때 하나 끊어보고 update하고 이런식으로 진행해야 하기 때문에 완전탐색 
        for(int i = 0; i < wires.length; i++) {
            v = new boolean[n+1];
            count = 0;
            int a = wires[i][0];
            int b = wires[i][1];
            
            arr[a].remove(Integer.valueOf(b));
            arr[b].remove(Integer.valueOf(a));
            
            // DFS
            DFS(1);
            
            // 복구
            arr[a].add(b);
            arr[b].add(a);
            
            int diff = Math.abs(count - (n - count));
            minCount = Math.min(minCount, diff);
        }
        
        return minCount;
    }
    
    public void DFS(int node) {
        // 방문 처리 
        v[node] = true;
        count++;
        
        for(int a : arr[node]) {
            if( !v[a] ) DFS(a);
        }
    
    }
}