import java.util.*;

class Solution {
    Map<String, PriorityQueue<String>> map;
    ArrayList<String> answerLst;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        answerLst = new ArrayList<>();
        
        // 1. 인접 연결 리스트 생성 및 초기화 -> HashMap
        map = new HashMap<>();
    
        for(String[] ticket : tickets) {
            String start = ticket[0];
            String end = ticket[1];
            
            map.putIfAbsent(start, new PriorityQueue<>());
            map.get(start).add(end);
        }
        
        DFS("ICN");
        Collections.reverse(answerLst);
        
        return answerLst.toArray(new String[0]);
    }
    
    public void DFS(String s) {
        PriorityQueue<String> pq = map.get(s);
        
        while( pq != null && !pq.isEmpty() ) {
            DFS(pq.poll());
        }
        
        // 연결되지 않은 s 먼저 추가됨
        // 종점부터 추가된다는 뜻
        answerLst.add(s);
    }
}