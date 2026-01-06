class Solution {
    String[] aeiou = {"A", "E", "I", "O", "U"};
    String word;
    int count;
    int answer;
    
    public int solution(String word) {
        answer = 0;
        this.word = word;
        
        // 1. DFS 시작 
        DFS("");
        
        return answer;
    }
    
    public void DFS(String s) {
        
        // 종료 1 ) 문자열의 길이 > 5
        if( s.length() > 5 ) return;
        
        // 종료 2 ) 내가 찾는 문자열과 현재 s 동일
        if( !s.equals("") ) {
            count++;
            if( s.equals(word) ) {
                answer = count;
                return;
            }
        }
        
        for(int i = 0; i < aeiou.length; i++) {
            DFS(s + aeiou[i]);
        }
    }
}