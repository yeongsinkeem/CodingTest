import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long H = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long row = (H + N) / (N + 1);
        long col = (W + M) / (M + 1);

        System.out.println(row * col);
    }
}

/*
// 메모리 초과 
public class P23971_ZOAC4 {
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 1. map 만들기 
		int[][] map = new int[H+1][W+1];
		
		// 2. 방문 배열
		visited = new boolean[H+1][W+1];

		// 3. BFS 시작 
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {1, 1});
		visited[1][1] = true;
		
		int count = 0;
		
		while(!q.isEmpty()) {
			count++;
			int curr[] = q.poll();
			int currX = curr[0];
			int currY = curr[1];
			
			System.out.println(currX + " " + currY);
			
			// visited[currX][currY] = true;
			
			int newX = currX + N + 1;
			int newY = currY + M + 1;
			
			// 두 좌표는 map 범위 벗어나지 않을 것 
			if( newX <= H && !visited[newX][currY] ) {
				q.offer(new int[] {newX, currY});
				visited[newX][currY] = true;
			}
			if( newY <= W && !visited[currX][newY] ) {
				q.offer(new int[] {currX, newY});
				visited[currX][newY] = true;
			}
		}
		
		System.out.println(count);
		
	}
}
*/