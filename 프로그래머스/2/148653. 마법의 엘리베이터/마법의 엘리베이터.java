class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while( storey > 0 ) {
            int digit = storey % 10;
            
            if( digit > 5 ) {
                answer += 10 - digit;
                storey = storey / 10 + 1;
            }
            
            else if( digit < 5 ) {
                answer += digit;
                storey = storey / 10;
            }
            
            else {
                answer += 5;
                // 그 다음 수로 결정
                int next = storey / 10 % 10;
                // 내리기 
                if( next < 5 ) {
                    storey = storey / 10;
                }
                else {
                    storey = storey / 10 + 1;
                }
            }
        }
        return answer;
    }
}