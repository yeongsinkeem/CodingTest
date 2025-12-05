import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        Stack<Integer> stack = new Stack<>();
        
        // 이때, 스택에는 "나" 보다 큰 요소들만 있을 것
        for(int i = 0; i < numbers.length; i++) {
            while( !stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int idx = stack.pop();
                answer[idx] = numbers[i];
            }
            stack.push(i);
        }
        
        return answer;
    }
}