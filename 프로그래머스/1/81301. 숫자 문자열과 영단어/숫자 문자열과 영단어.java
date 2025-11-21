import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // 1. Map 생성
        HashMap<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        
        StringBuilder newS = new StringBuilder();
        StringBuilder word = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // 숫자라면 
            if( Character.isDigit(c) ) {
                newS.append(c);
            } 
            // 알파벳이라면 
            else {
                word.append(c);
                
                if( map.containsKey(word.toString()) ) {
                    newS.append(map.get(word.toString()));
                    word = new StringBuilder();
                }
            }
                
        }
        
        return Integer.parseInt(newS.toString());
    }
}