import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// N = 키워드 개수 
		// M = 블로그에 쓴 글의 개수 
		// -> x번째 글을 쓰고 난 후 메모장에 남아있는 키워드의 개수 
		
		// 1. Set에 단어들 저장 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			String keyword = br.readLine();
			set.add(keyword);
		}
		
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < M; i++) {
			String post = br.readLine();
            String[] keywords = post.split(",");
            
            for(String k : keywords) {
                set.remove(k);
            }
			sb.append(set.size()).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}