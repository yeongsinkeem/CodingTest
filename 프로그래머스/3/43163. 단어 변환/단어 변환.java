import java.util.*;

class Solution {
    private String begin;
    private String target;
    
    private ArrayList<Integer> counts;
    private boolean[] visited;
    private String[] words;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        this.begin = begin;
        this.target = target;
        this.words = words;
        
        counts = new ArrayList<>();
        visited = new boolean[words.length];
        
        // 만약 words 안에 target이 없으면 바로 종료
        boolean exists = false;
        for (String str : words) {
            if (str.equals(target)) {
                exists = true;
                break;
            }
        }
        if (!exists) return 0;
        
        // 1. DFS 시작 - begin 가지고
        DFS(begin, 0);
        
        int[] countArr = new int[counts.size()];
        for(int i = 0; i < countArr.length; i++) {
            countArr[i] = counts.get(i);
        }
        
        Arrays.sort(countArr);
        
        return countArr[0];
    }
    
    public void DFS(String str, int depth) {
        // 종료 조건 
        if(str.equals(target)) {
            counts.add(depth);
            return;
        }
        
        // 방문 / 미방문 확인 
        for(int i = 0; i < words.length; i++) {
            if( !visited[i] && check(str, words[i]) ) {
                visited[i] = true;
                DFS(words[i], depth + 1);
                visited[i] = false;
            }
        }
    }
    
    // 한 번만에 갈 수 있는지 확인 
    public boolean check(String a, String b) {
        int diff = 0;
        for(int i = 0; i < a.length(); i++) {
            if(diff > 1) return false;
            
            if( a.charAt(i) != b.charAt(i) ) {
                diff ++;
            }
        }
        return diff == 1;
    }
}