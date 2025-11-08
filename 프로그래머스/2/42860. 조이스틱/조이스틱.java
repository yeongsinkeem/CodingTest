class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] nameArr = name.toCharArray();
        
        for (int i = 0; i < name.length(); i++) {
            int t = nameArr[i] - 'A';
            answer += Math.min(t, 26 - t);
        }
        
        
        int move = name.length() - 1;
        for(int i = 0; i < name.length(); i++) {
            int next = i + 1;
            
            // 연속된 A 건너뛰기 
            while( next < name.length() && nameArr[next] == 'A' ) {
                next ++;
            }
            
            move = Math.min(move, i * 2 + name.length() - next);
            move = Math.min(move, (name.length() - next) * 2 + i);
        }
        
        return answer + move;
    }
}