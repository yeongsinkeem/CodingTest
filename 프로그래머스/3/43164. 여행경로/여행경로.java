import java.util.*;

class Solution {
    Map<String, PriorityQueue<String>> adj = new HashMap<>();
    ArrayList<String> lst = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        
        // 1. 인접 연결리스트 생성 
        for(String[] t : tickets) {
            adj.putIfAbsent(t[0], new PriorityQueue<>());
            adj.get(t[0]).add(t[1]);
        }
        
        // 2. DFS 시작
        dfs("ICN");
        
        // 3. lst 거꾸로 !!!!!!!!
        Collections.reverse(lst);
        
        return lst.toArray(new String[0]);
    }
    
    public void dfs(String start) {
        // 1. start에서 연결된 도착지점들 가져오기
        PriorityQueue<String> arrivals = adj.get(start);
        
        // 2. 도착지점들이 있어야 재귀
        while( arrivals != null && !arrivals.isEmpty() ) {
            dfs( arrivals.poll() );
        }
        
        lst.add(start);
    }
}