import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 1. 신고 set 생성
        // 중복신고 없도록 
        Set<String> set = new HashSet<>();
        for(String r : report) {
            set.add(r);
        }
        
        // 2. <이름, 신고 횟수> map 생성 
        // ex. { muzi : 2, apeach : 2, .. }
        Map<String, Integer> map = new HashMap<>();
        
        // 3. 정지 유저 리스트 
        List<String> reportLst = new ArrayList<>();
        
        for(String s : set) {
            String bad = s.split(" ")[1];
            
            map.put(bad, map.getOrDefault(bad, 0) + 1);
            
            if(map.get(bad) >= k) reportLst.add(bad);
        }
        
        // 4. report 순회하면서 메일 받을 유저들 정리 
        Map<String, Integer> mail = new HashMap<>();
        for( String s : set ) {
            String bad = s.split(" ")[1];
            String reporter = s.split(" ")[0];
            
            // bad가 k번 이상 신고당했다면 
            if( map.getOrDefault(bad, 0) >= k ) {
                mail.put(reporter, mail.getOrDefault(reporter, 0) + 1);
            }
        }
        
        // 5. id_list 순서에 맞게 출력 
        int[] answer = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++) {
            answer[i] = mail.getOrDefault(id_list[i], 0);
        }
        
        return answer;
    }
}