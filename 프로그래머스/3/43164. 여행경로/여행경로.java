import java.util.*;

class Solution {
    Map<String, List<String>> map;
    Map<String, boolean[]> visitedMap;
    List<String> answerLst;
    boolean finished = false;
    String[][] tickets;
    
    public String[] solution(String[][] tickets) {
        answerLst = new ArrayList<>();
        this.tickets = tickets;
        
        // 1. map 생성 
        // ex. { ICN : {SFO, ATL, ... } } 이런식 
        map = new HashMap<>();
        visitedMap = new HashMap<>();
         
        // 2. 출발지와 도착지 연결 
        for(int i = 0; i < tickets.length; i++) {
            String start = tickets[i][0];
            String end = tickets[i][1];
            
            // map에 해당 키 없으면 생성 
            if( !map.containsKey(start) ) {
                map.put(start, new ArrayList<>());
            }
            // 해당 키에 도착지 추가 
            map.get(start).add(end);
        }
        
        // 3-1. 출발지 순회하면서 알파벳 정렬 + 방문 배열 생성 
        for(String s : map.keySet()) {
            Collections.sort(map.get(s));
            visitedMap.put(s, new boolean[map.get(s).size()]);
        }
        
        // 4. DFS 시작
        DFS("ICN", 0);
        
        // 5. 출력 
        String[] answer = new String[answerLst.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerLst.get(i);
        }
        
        return answer;
    }
    
    public void DFS(String departure, int count) {
        answerLst.add(departure);
        
        // 1. 모든 티켓 사용 
        if( count == tickets.length ) {
            finished = true;
            return;
        }
        
        // 백트래킹 
        if( !map.containsKey(departure) ) {
            // 바로 이전 요소 삭제 
            answerLst.remove(answerLst.size() - 1);
            return;
        }
        
        List<String> nextLst = map.get(departure);
        boolean[] visited = visitedMap.get(departure);
        
        // 연결된 지점들에 대해 DFS 
        for(int i = 0; i < nextLst.size(); i++) {
            if( visited[i] ) continue;
            
            visited[i] = true;
            DFS(nextLst.get(i), count + 1);
            
            if ( finished ) return;
            
            visited[i] = false;
        }
        
        // 백트래킹
        // 아직까지 finished = false 임
        // 이 공항에서 시작하는 모든 경로 실패 -> 해당 경로 삭제 
        answerLst.remove(answerLst.size() - 1);
    }
}