import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        int idx = 0;
        for(long n : numbers) {
            // 짝수 -> + 1
            if( n % 2 == 0 ) {
                answer[idx] = n + 1;
            }
            // 홀수 -> 가장 상위의 0을 1로 바꾸고 그 다음 비트 반전
            else {
                long bit = 1;
                while( (bit & n) != 0 ) {
                    bit = bit << 1;
                }
                answer[idx] = n + bit - (bit >> 1);
            }
            idx++;
        }
        return answer;
    }
}