import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 1. 정수 -> Str 배열로 변환
        String[] sArr = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            sArr[i] = String.valueOf(numbers[i]);
        }
        
        // 2. 정렬
        // a + b, b + a 있을 때 더 큰 순서대로
        Arrays.sort(sArr, (a, b) -> (b+a).compareTo(a+b));
        
        // 3. 모든 문자열이 0인 경우 
        if(sArr[0].equals("0")) return "0";
        
        StringBuilder answer = new StringBuilder();
        for(String s : sArr) {
            answer.append(s);
        }
        
        return answer.toString();
        
    }
}