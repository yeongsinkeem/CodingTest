import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static class move {
		int[] xy; // 현재 좌표 
		int direction; // 이동 화살표 
		int sum;
		
		public move(int[] xy, int direction, int sum) {
			this.xy = xy;
			this.direction = direction;
			this.sum = sum;
		}
	}
	
	static int[] pos = {2, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][M+1];
  
        
		// 1. map 설정
        for(int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 1; j <= M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        // 2. Queue 준비 
        Queue<move> q = new LinkedList<>();
        // int[] xy = {0, 0};
        // q.offer(new move(xy, 2, 0));
        // 이렇게 하면 한 방향으로밖에 못 내려 감 
        
        // 0행에서 각 열(1~M)로 내려가는 모든 경우의 수
        for (int j = 1; j <= M; j++) {
            // 처음 시작할 때는 이전 방향이 없으므로(특수값 2), 모든 방향(-1, 0, 1)으로 시작 가능
            q.offer(new move(new int[]{1, j}, -1, map[1][j]));
            q.offer(new move(new int[]{1, j}, 0, map[1][j]));
            q.offer(new move(new int[]{1, j}, 1, map[1][j]));
        }
        
        int minSum = 100 * N;
        // 3. BFS 시작 
        while( !q.isEmpty()) {
        	move curr = q.poll();
        	int[] currXY = curr.xy;
        	int currD = curr.direction;
        	int currS = curr.sum;
        	
        	// 만약 현재 x의 좌표가 N과 같다면 -> minSum 값 업데이트 
        	if( currXY[0] == N ) {
        		minSum = Math.min(currS, minSum);
        	}
        	
        	// 4. 이동 방향 
        	for(int i = 1; i <= 3; i++) {
        		int newX = currXY[0] + 1;
        		int newY = currXY[1] + pos[i];
        		
        		// 5. map 벗어나지 않고, 이전 방향이 아니라면 queue에 넣기 
        		if( newX <= N && newY <= M && newY >= 1 ) {
        			if( currD != pos[i] ) {
        				int[] newXY = {newX, newY};
        				int newS = currS + map[newX][newY];
        				q.offer(new move(newXY, pos[i], newS));
   
        			}
        		}
        	}
        }
        System.out.println(minSum);
	}
}