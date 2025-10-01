import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] jido; 
	static int[][] nJido;
	static boolean[][] visited;
	
	static int N;
	static int M;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로 
		M = Integer.parseInt(st.nextToken()); // 가로 
		
		jido = new int[N][M];
		nJido = new int[N][M];
		visited = new boolean[N][M];
		
		int xStart = 0; 
		int yStart = 0;
		// 1. 지도 입력 
		for(int i = 0; i < N; i++) { // 세로 
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M; j++) { // 가로 
				jido[i][j] = Integer.parseInt(st.nextToken());
				if(jido[i][j] == 2) {
					xStart = i;
					yStart = j;
				}
			}
		}
		
		// 2. 목표 지점에서 search 시작 
		BFS(xStart, yStart);
		
		// 3. 출력 
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(jido[i][j] == 0) sb.append(0).append(" ");
				else if(!visited[i][j]) sb.append(-1).append(" ");
				else sb.append(nJido[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
	}

	private static void BFS(int x, int y) {
		// 1. 초기 설정 및 큐 설정 
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		visited[x][y] = true;
		nJido[x][y] = 0; // 시작점 거리 
		
		while(!q.isEmpty()) {
			// 먼저 꺼내고 
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			// 상하좌우 탐색 
			for(int i = 0; i < 4; i++) {
				int goX = nowX + dx[i];
				int goY = nowY + dy[i];
				
				// 갈 수 없다면 
				if(goX < 0 || goY < 0 || goX >= N || goY >= M) continue;
				// 막혀 있거나 이미 방문했다면 
				if(jido[goX][goY] == 0 || visited[goX][goY]) continue;
				
				// 이동 및 값 업데이트 
				visited[goX][goY] = true;
				nJido[goX][goY] = nJido[nowX][nowY] + 1;
				q.add(new int[] {goX, goY});
			}
			
			
		}
	}
}