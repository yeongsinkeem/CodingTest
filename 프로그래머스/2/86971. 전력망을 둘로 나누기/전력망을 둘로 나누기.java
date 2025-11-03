import java.util.*;

class Solution {
    boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        // 1. 인접 연결 리스트 생성 및 초기화
        ArrayList<Integer>[] arrLst = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            arrLst[i] = new ArrayList<>();
        }
        
        // 2. 인접 연결 리스트 정의 
        for(int i = 0; i < wires.length; i++) {
            int a = wires[i][0] - 1;
            int b = wires[i][1] - 1;
            
            // 양방향 추가
            arrLst[a].add(b);
            arrLst[b].add(a);
        }
        
        // 3. 완전 탐색 시작 : 간선 제거 
        for(int i = 0; i < wires.length; i++) {
            int a = wires[i][0] - 1;
            int b = wires[i][1] - 1;
            
            // 4. 양방향 제거
            arrLst[a].remove(Integer.valueOf(b));
            arrLst[b].remove(Integer.valueOf(a));
            
            // 5. 제거했을 때 전력망 개수 세기
            visited = new boolean[n];
            // a 정점의 개수
            int count = countPower(arrLst, visited, a);
            
            // 6. 두 전력망의 차이 
            int diff = Math.abs( (n - count) - count);
            answer = Math.min(answer, diff);
            
            // 7. 백트래킹 : 양방향 다시 추가
            arrLst[a].add(b);
            arrLst[b].add(a);    
        }
        return answer;
    }
    
    // start와 연결된 정점 개수 세기 
    public int countPower(ArrayList<Integer>[] list, boolean[] v, int start) {
        v[start] = true;
        int count = 1;
        
        // 연결된 정점들에 대해 
        for(int a : list[start]) {
            if( !v[a] ) {
                count += countPower(list, v, a);
            }
        }
        
        return count;
    }
}