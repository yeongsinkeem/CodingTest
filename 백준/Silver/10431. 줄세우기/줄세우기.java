import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			int[] students = new int[20];
			int total = 0;
			
			for(int j = 0; j < 20; j++) {
				int curr = Integer.parseInt(st.nextToken());
				
				int countLarger = 0;
				
				// 이미 줄 서있는 학생들과 비교 
				for(int k = 0; k < j; k++) {
					// 이동해야 함 
					if( students[k] > curr ) {
						countLarger++;
					}
				}
				
				total += countLarger;
				// 현재 학생은 인덱스 그대로 삽입(실제 위치 이동 필요 x. 어차피 고정돼있어서) 
				students[j] = curr;
			}
			
			System.out.println(num + " " + total );
		}
	}

}