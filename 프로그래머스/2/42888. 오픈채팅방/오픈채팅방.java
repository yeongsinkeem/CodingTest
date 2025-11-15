import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answerLst = new ArrayList<>();
        
        // 1. nickMap 준비
        Map<String, String> nickMap = new HashMap<>();
        
        // 2. Enter, Change 일 때만 nickMap에 값 변경 
        for(String rec : record) {
            String action = rec.split(" ")[0];
            // Leave가 아닐 때만 nickMap에 저장 
            if( !action.equals("Leave") ) {
                String id = rec.split(" ")[1];
                String nick = rec.split(" ")[2]; 
                
                nickMap.put(id, nick);
            }
        }
        // nickMap = { (uid1234, Muzi), (uid4567, Ryan) }
        
        // 3. result 출력 
        // Enter, Leave 일 때만 
        for(int i = 0; i < record.length; i++) {
            String action = record[i].split(" ")[0];
            
            if( action.equals("Enter") ) {
                // id로 -> 닉네임 접근하기 
                String id = record[i].split(" ")[1];
                String nick = nickMap.get(id);
                
                answerLst.add(nick + "님이 들어왔습니다.");
            }
            else if( action.equals("Leave") ) {
                String id = record[i].split(" ")[1];
                String nick = nickMap.get(id);
                
                answerLst.add(nick + "님이 나갔습니다.");
            }
        }
        
        String[] answer = new String[answerLst.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerLst.get(i);
        }
        
        /*
        for(String id : nickMap.keySet()) {
            System.out.println(id + " : " + nickMap.get(id));
        }
        */
        
        return answer;
    }
}