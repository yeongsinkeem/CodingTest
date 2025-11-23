import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int who = 0;
        int turn = 0;
        
        Stack<String> stack = new Stack<>();
        
        int cnt = 0;
        
        // 1. 스택에 값 넣기
        for(String s : words) {
            cnt++;
            // 2. 첫번째 요소
            if( stack.isEmpty() ) {
                stack.push(s);
                // continue;
            }
            
            else {
                // 3. 이미 말했다면 
                if( stack.contains(s) ) {
                    who = (cnt % n == 0) ? n : cnt % n;
                    if( who > 0 && who != n ) turn = cnt / n + 1;
                    else turn = cnt / n;
                    break;
                }
                
                String prevS = stack.peek();
                // 4. 앞글자가 다르게 시작한다면 -> X
                if( prevS.charAt(prevS.length() - 1) != s.charAt(0)  ) {
                    who = (cnt % n == 0) ? n : cnt % n;
                    if( who > 0 && who != n )  {
                        turn = cnt / n + 1;
                    }
                    else {
                        turn = cnt / n;
                    }
                    break;
                }
                stack.push(s);
            }
        }
        
        answer[0] = who;
        answer[1] = turn;

        return answer;
    }
}