import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        for(int a : arr) {
            // 요소가 연속된다면 넘기기 
            if( !stack.isEmpty() && stack.peek() == a ) continue;
            
            stack.push(a);
        }
        
        int[] answer = new int[stack.size()];
        int idx = 0;
        for(int a : stack) {
            answer[idx++] = a;
        }
        
        return answer;
    }
}