import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, sNode;
	static ArrayList<Integer>[] dfs;
	static boolean[] vDFS; 
	static boolean[] vBFS;
	static ArrayList<Integer>[] bfs;
	static ArrayList<Integer> sDFS = new ArrayList<>();
	static ArrayList<Integer> sBFS = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sNode = Integer.parseInt(st.nextToken());
		
		// 1. 인접 배열 리스트, 방문 배열 초기화 
		dfs = new ArrayList[N+1];
		vDFS = new boolean[N+1];
		
		bfs = new ArrayList[N+1];
		vBFS = new boolean[N+1];
		
		for(int i = 1; i < N+1; i++) {
			dfs[i] = new ArrayList<>();
			bfs[i] = new ArrayList<>();
		}
		
		// 2. 인접 배열 리스트 연결 
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			dfs[a].add(b);
			dfs[b].add(a);
			
			bfs[a].add(b);
			bfs[b].add(a);
		}
		
		// 3. 배열 정렬 : 값이 작은 정점부터 탐색 
		for (int i = 1; i <= N; i++) {
		    Collections.sort(dfs[i]);
		    Collections.sort(bfs[i]);
		}
		
		// 4. DFS/BFS 시작 
		if( !vDFS[sNode] ) {
			DFS(sNode);
		}
		if( !vBFS[sNode] ) {
			BFS(sNode);
		}
		
		// 5. DFS/BFS 탐색 출력
		for(int a : sDFS) {
			System.out.print(a + " ");
		}
		System.out.println();
		for(int a : sBFS) {
			System.out.print(a + " ");
		}
	}

	private static void DFS(int node) {	
		// 방문 노드 -> 종료 
		if( vDFS[node] ) return;
		// 미방문 노드 -> 탐색
		vDFS[node] = true;
		sDFS.add(node);
		
		for(int a : dfs[node]) {
			if( !vDFS[a] ) {
				DFS(a);
			}
		}
	}
	
	private static void BFS(int node) {
		// 1. 시작 정점 넣어주기 
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(node);
		vBFS[node] = true;
		
		while( !queue.isEmpty() ) {
			// 2. queue에서 꺼내면서 -> 탐색 순서 넣어주기 
			int searchNode = queue.poll();
			sBFS.add(searchNode);
			
			// 3. 꺼낸 애들과 연결된 요소들 다시 queue에 넣어주기 
			// 이때 미방문 노드들만 
			for(int a : bfs[searchNode]) {
				if( !vBFS[a] ) {
					queue.offer(a);
					vBFS[a] = true;
				}
			}	
		}
	}
}