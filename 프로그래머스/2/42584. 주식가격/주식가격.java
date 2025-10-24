class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        int count = 1;
        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1; j < prices.length - 1; j++) {
                // 가격이 떨어진 경우
                if(prices[i] > prices[j]) {
                    answer[i] = count;
                    break;
                }
                count = count + 1;
            }
            if( i == prices.length - 1 ) {
                answer[i] = 0;
                break;
            }
            answer[i] = count;
            count = 1;
        }
        return answer;
    }
}