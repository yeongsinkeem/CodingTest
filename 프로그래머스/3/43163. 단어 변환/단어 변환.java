import java.util.*;

class Solution {
    class word {
        private String name;
        private int level;
        
        public word(String name, int level) {
            this.name = name;
            this.level = level;
        }
    }
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<word> q = new LinkedList<>();
        
        // 1. words에 target 없으면 0 반환
        List<String> wordsLst = new ArrayList<>();
        for(String w : words) {
            wordsLst.add(w);
        }
        if( !wordsLst.contains(target) ) return 0;
        
        q.offer(new word(begin, 0));
        // 2. BFS 시작
        while( !q.isEmpty() ) {
            word currWord = q.poll();
            String currName = currWord.name;
            int currLevel = currWord.level;
            
            if( currName.equals(target) ) return currLevel;
            
            for(int i = 0; i < words.length; i++) {
                // 3. 한글자만 다르고 미방문이라면 
                if( isDiff(words[i], currName) && !visited[i] ) {
                    q.offer(new word(words[i], currLevel + 1));
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
    
    // 한글자만 다르면 true
    // 아예 다르면 false
    public boolean isDiff(String a, String b) {
        int cnt = 0;
        
        for(int i = 0; i < a.length(); i++) {
            if( a.charAt(i) != b.charAt(i) ) cnt ++;
            
            if( cnt > 1 ) return false;
        }
        
        return true;
    }
}