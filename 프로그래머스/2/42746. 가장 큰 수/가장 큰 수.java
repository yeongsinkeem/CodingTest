import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] numStr = new String[numbers.length];
        
        // 1. 정수를 이어 붙여야 하기 때문에 String으로 형변환 
        for(int i = 0; i < numbers.length; i++) {
            numStr[i] = numbers[i] + "";
        }
        
        // 2. 이어 붙여서 큰 순서대로 정렬 
        Arrays.sort(numStr, (a, b) -> (b+a).compareTo(a+b));
        
        // 예외 처리 : 00000000000 -> 0으로 출력
        if( numStr[0].equals("0") ) return "0";
        
        // 3. StringBuilder 활용
        StringBuilder sb = new StringBuilder();
        
        for(String s : numStr) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}