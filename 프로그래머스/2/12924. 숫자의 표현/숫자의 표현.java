class Solution {
    public int solution(int n) {
        int answer = 1;
        
        int[] nArr = new int[n + 1];
        for(int i = 0; i < nArr.length; i++) {
            nArr[i] = i;
        }
        // nArr[0] = 0;
        // nArr[n] = n;
        
        int left = 0;
        int right = 0;
        
        int sum = 0;
        while( right < n ) {
            if( sum < n ) {
                right++;
                sum += nArr[right];
            }
            else if( sum > n ) {
                sum -= nArr[left];
                left++;
            }
            else {
                answer++;
                System.out.println(right);
                right++;
                sum += nArr[right];
                
            }
        }
        return answer;
    }
}