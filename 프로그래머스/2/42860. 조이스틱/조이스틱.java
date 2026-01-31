class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] c = name.toCharArray();
        
        // 1. 알파벳 
        int alpha = 0;
        for(int j = 0; j < c.length; j++) {
            int diff = c[j] - 'A';
            alpha += Math.min(diff, 26 - diff);
        }
        
        // 2. 거리
        int move = c.length - 1;
        for(int i = 0; i < c.length; i++) {
            int next = i + 1;
            // 연속된 A들 찾기 
            while( next < c.length && c[next] == 'A' ) {
                next++;
            }
            
            // 순방향 -> 역방향 
            move = Math.min( move, i + i + (c.length - next) );
            // 역방향 -> 순방향
            move = Math.min( move, (c.length - next) * 2 + i );
        }
        
        return move + alpha;
    }
}