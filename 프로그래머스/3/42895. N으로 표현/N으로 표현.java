import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        if( N == number ) return 1;
        
        // 1. dp 만들기 
        List<Set<Integer>> dp = new ArrayList<>();
        for(int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        
        // 2. dp[1] = N
        dp.get(1).add(N);
        
        // 3. i = 2 ~ 8까지 dp 만들기
        for(int k = 2; k <= 8; k++) {
            // 4. 숫자 붙이기
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < k; i++) {
                sb.append(N);
            }
            dp.get(k).add(Integer.parseInt(sb.toString()));
            
            // 5. 사칙연산
            // dp[5] = dp[1] + dp[4], dp[2] + dp[3]
            for(int i = 1; i < k; i++) {
                int j = k - i;
                
                for(int a : dp.get(i)){
                    for(int b : dp.get(j)) {
                        dp.get(k).add(a + b);
                        dp.get(k).add(a - b);
                        dp.get(k).add(a * b);
                        if( b != 0 ) {
                            dp.get(k).add(a / b);
                        }
                    }
                }
            }
            
            if( dp.get(k).contains(number) ) return k;
        }
    
        return -1;
    }
}