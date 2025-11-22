class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        // 1. skill_trees 순회
        for(String s : skill_trees) {
            String newS = "";
            
            // 2. 새로운 문자열 만들기 
            for(int i = 0; i < s.length(); i++) {
                if( skill.contains(s.charAt(i) + "") ) {
                    newS += s.charAt(i) + "";
                }
            }
            
            // 2. 만들어진 문자열과 skill 비교 
            boolean flag = true;
            for(int i = 0; i < newS.length(); i++) {
                if( newS.charAt(i) != skill.charAt(i) ) {
                    flag = false;
                    break;
                }
            }
            
            if ( flag == true ) answer ++;
            
        }
        return answer;
    }
}