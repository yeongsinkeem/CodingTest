import java.util.*;

class Solution {
    public class Server{
        int time;
        int cnt;
        
        public Server(int time, int cnt) {
            this.time = time;
            this.cnt = cnt;
        }
    }
    
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int currServer = 0;
        int needServer;
        Queue<Server> q = new LinkedList<>();
        
        for(int i = 0; i < players.length; i++) {
            // 1. 필요한 서버 개수 세기 
            needServer = players[i] / m;
            
            // 서버 반납 
            // 이때 빌린 개수만큼 반납해야 함
            if( !q.isEmpty() && i == q.peek().time + k ) {
                Server minusServer = q.poll();
                currServer -= minusServer.cnt;
            }
            
            // 증설 
            if( currServer < needServer ) {
                // 빌려야 하는 서버 개수 
                int rent = needServer - currServer;
                answer += rent;
                
                currServer += rent;
                
                q.offer(new Server(i, rent));
            }
        }
        
        return answer;
    }
}