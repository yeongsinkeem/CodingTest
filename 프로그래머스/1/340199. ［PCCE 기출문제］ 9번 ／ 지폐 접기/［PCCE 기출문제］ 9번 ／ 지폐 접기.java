class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        // 1. 초기 설정
        int bigB = Math.max(bill[0], bill[1]);
        int smallB = Math.min(bill[0], bill[1]);
        
        int bigW = Math.max(wallet[0], wallet[1]);
        int smallW = Math.min(wallet[0], wallet[1]);
        
        while( bigB > bigW || smallB > smallW ) {
            answer++;
            
            // 2. 큰 거 절반으로 접기
            // preBigB = 13
            int preBigB = bigB / 2;
            
            // 3. 지갑 돌려보기 
            bigB = Math.max(preBigB, smallB);
            smallB = Math.min(preBigB, smallB);
            
            // System.out.println(bigB + ", " + smallB);
        }
        
        return answer;
    }
}