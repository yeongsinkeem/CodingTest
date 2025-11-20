class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        // 1. 대소문자 변환
        s = s.toLowerCase();
        
        int p = 0;
        int y = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if( s.charAt(i) == 'p' ) p++;
            else if( s.charAt(i) == 'y' ) y++;
        }
        
        System.out.println(p + ", " + y);
        
        if( p != y ) return false;
        
        
        return answer;
    }
}