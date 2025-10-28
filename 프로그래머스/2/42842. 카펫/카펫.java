class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 1. 전체 개수 입력 
        int total = brown + yellow;
        
        // 2. 공약수 구하기
        for(int i = 2; i <= total ; i++) {
            if( total % i == 0 ) {
                int a = i;
                int b = total / i;
                
                if( (a - 2) * (b - 2) == yellow ) {
                    answer[0] = a;
                    answer[1] = b;
                }
            }
        }
        
        return answer;
    }
}