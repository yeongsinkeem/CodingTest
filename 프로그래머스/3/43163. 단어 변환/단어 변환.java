import java.util.*;

class Solution {
    public class Word{
        String name;
        int count;
        
        public Word(String name, int count) {
            this.name = name;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        // 만약 해당 단어가 words에 없다면 바로 종료 
        boolean flag = false;
        for(String w : words) {
            if( w.equals(target) ) {
                flag = true;
            }
        }
        if( !flag ) return 0;
        
        // 1. 큐 준비 
        Queue<Word> q = new LinkedList<>();
        boolean[] v = new boolean[words.length];
        
        // 1. BFS 시작
        q.offer(new Word(begin, 0));
        
        int count = 1;
        while( !q.isEmpty() ) {
            Word curr = q.poll();
            
            // 해당 단어가 target과 같다면 종료 
            if( curr.name.equals(target) ) {
                return curr.count;
            }
            
            // 2. words 순회하면서 
            // 미방문 + 한 글자만 달라야 
            for(int i = 0; i < words.length; i++) {
                if( !v[i] ) {
                    
                    if( check(curr.name, words[i]) ) {
                        // System.out.println("실행" + " " + words[i] + " " + curr.count);
                        v[i] = true;
                        q.offer(new Word(words[i], curr.count + 1));
                    }
                }
            }
        }
        
        return answer;
    }
    
    public boolean check(String a, String b) {
        int count = 0;
        
        for(int i = 0; i < a.length(); i++) {
            if( a.charAt(i) != b.charAt(i) ) {
                count++;
            }
        }
        if( count <= 1 ) return true;
        else return false;
    }
}