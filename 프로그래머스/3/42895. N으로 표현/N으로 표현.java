import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        if( N == number ) {
            return 1;
        }
        
        // 1. 요소가 HashSet DP 리스트 만들기
        List<Set<Integer>> dpSets = new ArrayList<>();
        for(int i = 0; i <= 8; i++) {
            dpSets.add(new HashSet<>());
        }
        
        // 2. k = 1일 때 초기값 설정
        dpSets.get(1).add(N);
        
        // 3. k = 2 ~ 8까지 탐색 
        for(int k = 2; k <= 8; k++) {
            // 4. 문자열 이어 붙이기 ex. 5, 55, 555
            StringBuilder sb = new StringBuilder();
            for(int count = 0; count < k; count++) {
                sb.append(N);
            }
            dpSets.get(k).add(Integer.parseInt(sb.toString()));
            
            // 5. i와 j 탐색하면서 dpSets에 값 추가하기
            for(int i = 1; i < k; i++) {
                int j = k - i;
                
                // N을 i번 사용
                Set<Integer> set1 = dpSets.get(i);
                Set<Integer> set2 = dpSets.get(j);
                
                for(int a : set1) {
                    for(int b : set2) {
                        dpSets.get(k).add(a + b);
                        dpSets.get(k).add(a - b);
                        dpSets.get(k).add(a * b);
                        
                        if( b != 0 ) dpSets.get(k).add(a / b);
                    }
                }
            }
            
            // 6. k번째 HashSet에 number있는지 확인
            if(dpSets.get(k).contains(number)) return k;
        }
        
        
        return -1;
    }
}