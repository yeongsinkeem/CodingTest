
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static class Nation {
		int idx;
		int gold;
		int silver;
		int bronze;
		
		public Nation(int idx, int gold, int silver, int bronze) {
			this.idx = idx;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		// 1. 국가 리스트 생성 
		Nation[] nationLst = new Nation[N+1];
		
		// 2. 국가별 메달 설정 
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int idx = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			
			nationLst[i] = new Nation(idx, gold, silver, bronze);
		}
		
		// 3. 정렬 
		List<Nation> list = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			list.add(nationLst[i]);
		}
		
		// 이때 동점자 처리 
		list.sort( (a, b) -> {	
			if( a.gold!= b.gold ) return b.gold - a.gold;
			if( a.silver != b.silver ) return b.silver - a.silver;
			return b.bronze - a.bronze;
		});
		
		// 4. 순위 출력 
		int rank = 1;
		for(int i = 0; i < N; i++) {
			if( i > 0 ) {
				Nation prev = list.get(i-1);
				Nation curr = list.get(i);
				
				// 만약 메달 개수 다르다면 
				if( prev.gold != curr.gold ||
					prev.silver != curr.silver ||
					prev.bronze != curr.bronze
				) rank = i + 1;
			}
			
			if( target == list.get(i).idx ) {
				System.out.println(rank);
				return;
			}
		}
	}
}