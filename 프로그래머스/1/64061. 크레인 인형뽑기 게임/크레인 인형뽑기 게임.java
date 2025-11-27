import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        // 1. 요소가 Stack인 board 만들기 
        Queue<Integer>[] boardQ = new LinkedList[board.length];
        
        for(int i = 0; i < boardQ.length; i++) {
            boardQ[i] = new LinkedList<Integer>();
        }
        
        // 2. 인형맵 설정 
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                int element = board[j][i];
                
                // 0이 아닐 때만 넣어주기 
                if( element != 0 ) boardQ[i].offer(element);
            }
        }
        
        for(int i = 0; i < boardQ.length; i++) {
            for(int j : boardQ[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    
        // 3. moves에 넣어주기 
        Stack<Integer> moveS = new Stack<>();
        
        for(int i = 0; i < moves.length; i++) {
            int m = moves[i];
            
            if( !boardQ[m-1].isEmpty() ) {
                int curr = boardQ[m-1].poll();
                System.out.println(curr);
                
                if( !moveS.isEmpty() && moveS.peek() == curr ) {
                    System.out.println("같음");
                    moveS.pop();
                    answer++;
                    continue;
                }
                
                moveS.push(curr);
            }
        }
        
        return answer * 2;
    }
}