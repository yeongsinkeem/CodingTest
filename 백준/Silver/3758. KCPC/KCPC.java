
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static class Team {
		int id;
		int[] scores;
		int totalScore;
		int submitCount;
		int lastSubmit;
		
		public Team(int id, int k) {
			this.id = id;
			this.scores = new int[k+1];
			this.totalScore = 0;
			this.submitCount = 0;
			this.lastSubmit = 0;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testData = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testData; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 팀의 개수 n, 문제의 개수 k, 당신 팀의 ID t, 로그 엔트리의 개수 m
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			// 1. team 클래스 배열 생성 
			Team[] teamLst = new Team[n+1];
			
			// 팀 배열 초기화 및 생성 
			for(int j = 1; j <= n; j++) {
				teamLst[j] = new Team(j, k);
			}
			
			// 2. team 클래스 업데이트 
			for(int j = 1; j <= m; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()); // 팀 id
				int b = Integer.parseInt(st.nextToken()); // 문제 번호 
				int c = Integer.parseInt(st.nextToken()); // 점수 
				
				// 팀 객체 지정(생성 절대 아님)
				Team team = teamLst[a];
				
				team.submitCount ++;
				team.lastSubmit = j;
				// 최고 점수일 때만 수정 
				if( c > team.scores[b] ) {
					team.totalScore -= team.scores[b];
					team.totalScore += c;
					team.scores[b] = c;
				}
			}
			
			// 3. 등수 정렬 (점수 -> 제출 횟수 -> 마지막 제출 시간)
			// 정렬해야 하기 때문에 List 사용 
			List<Team> list = new ArrayList<>();
			for(int j = 1; j <= n; j++) list.add(teamLst[j]);
			
			list.sort( (a, b) -> {
				if( a.totalScore != b.totalScore ) {
					return b.totalScore - a.totalScore;
				}
				if( a.submitCount != b.submitCount ) {
					return a.submitCount - b.submitCount;
				}
				
				return a.lastSubmit - b.lastSubmit;
			} );
			
			// 4. 등수 계산 
			int rank = 1;
			for(Team team : list) {
				if( team.id == t ) break;
				rank ++;
			}
			System.out.println(rank);
		}
		
	}
}