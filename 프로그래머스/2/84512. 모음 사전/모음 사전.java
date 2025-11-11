import java.util.*;

class Solution {
    String curr;
    List<String> lst;
    String[] aeiou = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        int answer = 0;
        
        // 1. 리스트 준비
        lst = new ArrayList<>();
        
        curr = "";
        DFS(curr);
        
        return lst.indexOf(word) + 1;
    }
    
    public void DFS(String s) {
        // 1. 종료조건
        if( s.length() > 5 ) return;
        
        if( !s.isEmpty() ) lst.add(s);
        
        for(int i = 0; i < 5; i++) {
            DFS( s + aeiou[i] );
        }
    }
}