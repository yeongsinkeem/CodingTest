import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        // 1. 다중집합 만들기
        ArrayList<String> m1 = makeMultiset(str1);
        ArrayList<String> m2 = makeMultiset(str2);
        
        // 2. 두 리스트 원본 크기
        int m1Size = m1.size();
        int m2Size = m2.size();
        
        // 3. 교집합 
        int intersection = 0;
        for(String s : m1) {
            if( m2.remove(s) ) intersection++;
        }
        
        // 4. 합집합 계산
        int union = m1Size + m2Size - intersection;
        
        // 5. 계산
        if( union == 0 ) return 65536;
        
        double jac = (double) intersection / union;
        
        return (int) (jac * 65536);
    }
    
    public ArrayList<String> makeMultiset(String str) {
        // 1. 소문자 변환
        String s = str.toLowerCase();
        ArrayList<String> multiSet = new ArrayList<>();
        
        for(int i = 0; i < s.length() - 1; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i+1);
            
            if( isAlphabet(a) && isAlphabet(b) ) {
                multiSet.add(Character.toString(a) + Character.toString(b));
            }
        }
        return multiSet;
    }
    
    public boolean isAlphabet(char c) {
        if( c >= 'a' && c <= 'z' ) return true;
        return false;
    }
}