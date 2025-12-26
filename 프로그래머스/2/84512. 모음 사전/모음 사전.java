import java.util.*;

class Solution {
    char[] charArr = {'A', 'E', 'I', 'O', 'U'};
    List<String> lst = new ArrayList<>();
    
    public int solution(String word) {
        int answer = 0;
        
        // 완전탐색 시작
        DFS("");
        
        String[] sArr = new String[lst.size()];
        for(int i = 0; i < sArr.length; i++) {
            sArr[i] = lst.get(i);
        }
        
        for(int i = 0; i < sArr.length; i++) {
            if( sArr[i].equals(word) ) return i+1;
        }
        
        return answer;
    }
    
    public void DFS(String s) {
        if( !s.equals("") ) {
            lst.add(s);
        }
        
        if( s.length() == 5 ) return;
        
        for(char c : charArr) {
            DFS(s + c);
        }
    }
}