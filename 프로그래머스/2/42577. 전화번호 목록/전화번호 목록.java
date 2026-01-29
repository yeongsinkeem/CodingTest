import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        for(int j = 0; j < phone_book.length - 1; j++) {
            if( phone_book[j+1].startsWith(phone_book[j]) ) return false;
        }
        
        return answer;
    }
}