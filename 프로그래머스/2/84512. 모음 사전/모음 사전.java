import java.util.*;

class Solution {
    static List<String> dic = new ArrayList<>();
    static String[] alArr = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        int answer = 0;
        
        String curr = "";
        DFS(curr);
        
        return dic.indexOf(word) + 1;
    }
    
    public void DFS(String str) {
        // 1. 단어 먼저 추가
        if(!str.isEmpty()) {
            dic.add(str);
        }
        
        // 2. 종료 조건 -> 단어 길이 5
        if(str.length() == 5) {
            return;
        }
        
        // 3. 알파벳 붙이기
        for(int i = 0; i < alArr.length; i++) {
            DFS(str + alArr[i]);
        }
    }
}