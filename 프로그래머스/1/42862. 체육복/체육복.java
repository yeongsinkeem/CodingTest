import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        // 1. 전체 배열 생성
        int[] total = new int[n+1];
        for(int i = 1; i <= n; i++) {
            total[i] = 1;
        }
        
        // 2. 잃어버렸다면 - 1
        for(int l : lost) {
            total[l]--;
        }
        
        // 3. 여분 있다면 + 1
        for(int r : reserve) {
            total[r]++;
        }
        
        // 4. 대여
        for(int i = 1; i <= n; i++) {
            if( total[i] == 0) {
                // 앞 번호 학생에게 빌릴 수 있는지
                if( i > 1 && total[i-1] == 2 ) {
                    total[i] = 1;
                    total[i-1] = 1;
                }
                // 뒷 번호 학생에게 빌릴 수 있는지
                else if( i + 1 <= n && total[i+1] == 2 ) {
                    total[i+1] = 1;
                    total[i] = 1;
                }
            }
        }
        
        for(int i = 0; i < total.length; i++) {
            if( total[i] >= 1 ) answer++;
        }
        
        return answer;
    }
}