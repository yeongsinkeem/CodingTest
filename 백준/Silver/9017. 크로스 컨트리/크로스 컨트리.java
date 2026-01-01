import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testCase; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] players = new int[N];
			for(int j = 0; j < N; j++) {
				players[j] = Integer.parseInt(st.nextToken());
			}
			
			// 1. 팀별 인원 수 세기
			Map<Integer, Integer> map = new HashMap<>();
			for(int p : players) {
				map.put(p, map.getOrDefault(p, 0) + 1);
			}
			
			// 2. 인원이 6명인 팀만 유효 
			Set<Integer> set = new HashSet<>();
			for(int m : map.keySet()) {
				if( map.get(m) == 6 ) set.add(m);
			}
			
			// 3. 팀별 점수 기록 
			// Map<팀, 팀원들의 점수>
			Map<Integer, List<Integer>> scoreMap = new HashMap<>();
			for(int s : set) {
				scoreMap.put(s, new ArrayList<>());
			}
			
			int score = 1;
			for(int p : players) {
				if( set.contains(p) ) {
					scoreMap.get(p).add(score);
					score++;
				}
			}
			
			// 4. 우승 팀 점수 계산 
			int winner = 0;
			int minSum = Integer.MAX_VALUE;
			int minFifth = Integer.MAX_VALUE;
			
			// 유효한 팀들에 한해서만 
			for(int s : set) {
				// 해당 팀 점수 가져오기 
				List<Integer> list = scoreMap.get(s);
				int sum = 0;
				for(int j = 0; j < 4; j++) {
					sum += list.get(j);
				}
				
				int fifth = list.get(4);
				
				if( sum < minSum || (sum == minSum) && fifth < minFifth ) {
					minSum = sum;
					minFifth = fifth;
					winner = s;
				}
			}
			
			sb.append(winner).append("\n");
		}
		
		System.out.print(sb);
	}
}