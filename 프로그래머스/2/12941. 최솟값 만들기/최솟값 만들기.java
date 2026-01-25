import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        // 최종적으로 누적된 값이 최소가 되도록
        // 작은 것 x 큰 것끼리 곱해져야 함
        Arrays.sort(A);
        Arrays.sort(B);
        
        int[] descB = new int[B.length];
        int len = descB.length - 1;
        
        for(int i = 0 ; i <= len; i++) {
            descB[len - i] = B[i];
        }
        
        for(int i = 0; i < A.length; i++) {
            answer += A[i] * descB[i];
        }
        

        return answer;
    }
}