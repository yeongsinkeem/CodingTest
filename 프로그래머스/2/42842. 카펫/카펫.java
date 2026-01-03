class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow;
        
        // 1. 약수 순회 
        for(int i = 1; i <= total; i++) {
            if( total % i == 0 ) {
                int a = i;
                int b = total / i;
                
                if( (a * 2) + (b * 2) - 4 == brown ) {
                    answer[0] = b;
                    answer[1] = a;
                    
                    return answer;
                }
            }
        }
        return answer;
    }
}