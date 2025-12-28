import java.util.*;

public class Main {
    static int N;
    static boolean[] visited;
    static List<Integer> lst;
    static int[] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        
        lst = new ArrayList<>();
        
        // 1. arr 채우기
        for(int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        
        // 2. DFS 시작 
        for(int i = 1; i <= N; i++) {
            visited[i] = true;
            DFS(i, i);
            visited[i] = false;
        }
        
        Collections.sort(lst);
        System.out.println(lst.size());
        for(int num : lst) {
            System.out.println(num);
        }
	}
    
    public static void DFS(int start, int end) {
        // 미방문 노드에 대해서만
        if( !visited[arr[start]] ) {
            visited[arr[start]] = true;
            DFS(arr[start], end);
            visited[arr[start]] = false;
        }
        
        if( arr[start] == end ) {
            lst.add(end);
        }
    }
}
