class Solution {
    public int solution(String name) {
        char[] c = name.toCharArray();
        int alpha = 0;
        
        // 1. 알파벳 계산
        for(int i = 0; i < c.length; i++) {
            int diff = c[i] - 'A';
            alpha += Math.min(diff, 26 - diff);
        }
        
        // 2. 거리 계산
        // 2-1. 쭉 가기
        int move = name.length() - 1;
        
        for(int i = 0; i < c.length; i++) {
            int next = i + 1;
            
            // 연속된 A 건너뛰기
            while( next < c.length && c[next] == 'A') {
                next++;
            }
            // 2-2. 순 -> 역
            move = Math.min(move, i + i + (c.length - next));
            
            // 2-3. 역 -> 순
            move = Math.min(move, (c.length - next) * 2 + i );
        }
        
        return alpha + move;
    }
}