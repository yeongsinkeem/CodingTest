import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	public static class Team{
		// 점수표
		// 횟수 
		// 마지막 시간 
		// 총 점수 
		int id;
		int[] scores;
		int count;
		int last;
		int totalScore;
		
		public Team(int id, int k) {
			this.id = id;
			this.scores = new int[k+1];
			this.count = 0;
			this.last = 0;
			this.totalScore = 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// 15 : 14 ~ 16 : 20
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			// 1. 각 팀 클래스 생성 
			Team[] teamLst = new Team[n+1];
			for(int j = 1; j <= n; j++) {
				teamLst[j] = new Team(j, k);
			}
			
			// 2-1. 각 팀 점수, 마지막 로그 등 설정 
			for(int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				
				int team = Integer.parseInt(st.nextToken());
				int question = Integer.parseInt(st.nextToken());
				int questionScore = Integer.parseInt(st.nextToken());
				
				teamLst[team].count++;
				teamLst[team].last = j;
				
				// 문제 최고 점수만 저장 
				teamLst[team].scores[question] = 
						Math.max(teamLst[team].scores[question], questionScore);
			}
			
			// 2-2. 각 팀 총 점수 계산 
			for(int j = 1; j <= n; j++) {
				int sum = 0;
				for(int z = 1; z <= k; z++) {
					sum += teamLst[j].scores[z];
				}
				
				teamLst[j].totalScore = sum;
			}
			
			// 3. 정렬 
			// 3-2. 각 팀의 횟수 
			// 3-3. 각 팀의 마지막 시간 
			Arrays.sort(teamLst, 1, n + 1, (a, b) -> {
				// 3-1. 각 팀의 총점 
				if( a.totalScore != b.totalScore ) {
					return b.totalScore - a.totalScore;
				}
				
				// 3-2. 각 팀의 횟수 
				if( a.count != b.count ) {
					return a.count - b.count;
				}
				
				return a.last - b.last;
			});
			
			int rank = 0; 
			// 4. 등수 계산 
			for(int j = 1; j <= n; j++) {
				if( t == teamLst[j].id ) {
					rank = j;
					break;
				}
			}
			sb.append(rank);
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
		
	}
}