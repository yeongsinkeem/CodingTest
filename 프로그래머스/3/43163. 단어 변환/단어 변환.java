import java.util.*;

class Solution {
    class Node {
        String word;
        int depth;
        
        public Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        // 전제 조건 - target이 words에 있을 것
        boolean exists = false;
        for(String str : words) {
            if(str.equals(target)) {
                exists = true;
                break;
            }
        }
        if( !exists ) return 0;
        
        // 1. queue & visited 준비
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        queue.offer(new Node(begin, 0));
        
        // 2. BFS 시작
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            String currWord = curr.word;
            int currDepth = curr.depth;
            
            // target 찾았다면 
            if(currWord.equals(target)) return currDepth;
            
            // target 못 찾았다면 탐색 
            for(int i = 0; i < words.length; i++) {
                // 미방문 + 한 번만에 갈 수 있다면 
                if( !visited[i] && check(currWord, words[i]) ) {
                    visited[i] = true;
                    queue.offer(new Node(words[i], currDepth + 1));
                }
            }
        }
        return 0;
    }
    
    public boolean check(String a, String b) {
        int diff = 0;
        for(int i = 0; i < a.length(); i++) {
            if (diff > 1) return false;
            
            if( a.charAt(i) != b.charAt(i) ) diff++;
        }
        return diff == 1;
    }
}