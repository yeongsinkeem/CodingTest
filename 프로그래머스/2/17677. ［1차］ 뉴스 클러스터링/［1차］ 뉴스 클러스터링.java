import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        // 1. 두 글자씩 끊어서 다중 원소 만들기 
        // 이때 특수 문자가 있는 다중 원소는 버리기
        // 모두 대문자로 만들기 
        List<String> str1Lst = new ArrayList<>();
        List<String> str2Lst = new ArrayList<>();
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        for(int i = 0; i < str1.length() - 1; i++) {
            String s = str1.substring(i, i+2);
            
            if( alphabetic(s) ) str1Lst.add(s);
        }
        
        
        for(int i = 0; i < str2.length() - 1; i++) {
            String s = str2.substring(i, i+2);
            
            if( alphabetic(s) ) str2Lst.add(s);
        }
        
        // 2. 교집합 계산
        boolean[] visited1 = new boolean[str2Lst.size()];
        int cnt1 = 0;
        for(int i = 0; i < str1Lst.size(); i++) {
            for(int j = 0; j < str2Lst.size(); j++) {
                if( str1Lst.get(i).equals(str2Lst.get(j)) && !visited1[j] ) {
                    cnt1 ++;
                    visited1[j] = true;
                    break;
                }
            }
        }
        
        if( str1Lst.size() == 0 && str2Lst.size() == 0 ) return 65536;
        
        // 3. 합집합 계산 
        double cnt2 = str1Lst.size() + str2Lst.size() - cnt1;
        
        double jac =  cnt1 / cnt2;
        answer = (int) ( jac * 65536);
        
        return answer;
    }
    
    public boolean alphabetic(String s) {
        
        for(char c : s.toCharArray()) {
            if( c < 65 || c > 90 ) {
                return false;
            }
        }
        
        return true;
    }
}