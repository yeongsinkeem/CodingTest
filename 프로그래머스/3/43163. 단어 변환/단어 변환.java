import java.util.*;

class Solution {
    public class Word {
        String name;
        int depth;
        
        public Word(String name, int depth) {
            this.name = name;
            this.depth = depth;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        // 1. words에는 target이 존재해야 함 
        boolean exit = false;
        for(String s : words) {
            if( s.equals(target) ) exit = true;
        }
        if( exit == false ) return 0;
        
        // 2. BFS 시작 전 큐와, 방문 배열 준비
        Queue<Word> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        queue.offer(new Word(begin, 0));
        
        // 3. BFS 시작
        while( !queue.isEmpty() ) {
            Word currWord = queue.poll();
            String currName = currWord.name;
            int currDepth = currWord.depth;
            
            // 4. 만약 현재 단어가 target이라면 종료 
            if ( currName.equals(target) ) {
                // currDepth++;
                return currDepth;
            }
            
            // 5. words 순회하면서 단어 변환
            for(int i = 0; i < words.length; i++) {
                // 미방문 + 한번만에 갈 수 있는지 
                if( !visited[i] && isOnce(currName, words[i]) ) {
                    visited[i] = true;
                    queue.offer(new Word(words[i], currDepth + 1));
                }
            }
        }
    
        return answer;
    }
    
    public boolean isOnce(String a, String b) {
        int diff = 0;
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        
        for(int i = 0; i < a.length(); i++) {
            if( aArr[i] != bArr[i] ) diff++;
            
            if(diff > 1) return false;
        }
        
        return true;
    }
}