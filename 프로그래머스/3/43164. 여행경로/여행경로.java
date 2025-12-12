import java.util.*;

class Solution {
    static HashMap<String, PriorityQueue<String>> map;
    static ArrayList<String> answerLst = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        map = new HashMap<>();
        
        // 1. 인접 연결 큐 생성 
        for(String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            
            // 없으면 큐 생성 
            map.putIfAbsent(from, new PriorityQueue<>());
            map.get(from).offer(to);
        }
        
        // 2. 인천부터 시작 
        DFS("ICN");
        
        Collections.reverse(answerLst);
        
        String[] answer = new String[answerLst.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerLst.get(i);
        }
     
        return answer;
    }
    
    public void DFS(String start) {
        
        // 출발지여야 하고 비어있지 않아야 
        while( map.containsKey(start) && !map.get(start).isEmpty() ) {
            String next = map.get(start).poll();
            DFS(next);
        }
        
        // 마지막 공항부터 기록 
        answerLst.add(start);
    }
}