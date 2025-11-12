class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int minLen = Integer.MAX_VALUE;
        
        for(int i = 0; i < sequence.length; i++) {
            if( sequence[i] == k ) {
                answer[0] = i;
                answer[1] = i;
                return answer;
            }
        }
        
        int left = 0;
        int right = 0;
        int n = sequence.length;
        int sum = sequence[left];
        
        while( left < n && right < n ) {
            if(sum < k) {
                right ++;
                
                if( right < n ) sum += sequence[right];
            }
            
            else if(sum == k) {
                int len = right - left + 1;
                
                if ( len < minLen ) {
                    minLen = len;
                    answer[0] = left;
                    answer[1] = right;
                }
                
                sum -= sequence[left];
                left ++;
            }
            
            else {
                sum -= sequence[left];
                left ++;
            }
        }
        
        return answer;
    }
}