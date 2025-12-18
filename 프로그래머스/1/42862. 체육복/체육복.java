class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n];
        
        for(int i = 0; i < students.length; i++) {
            students[i] = 1;
        }
        
        // 도난
        for(int i = 0; i < lost.length; i++) {
            int num = lost[i];
            students[num - 1] = 0;
        }
        
        // 여분
        for(int i = 0; i < reserve.length; i++) {
            int num = reserve[i];
            students[num - 1] = students[num - 1] + 1;
        }
        
        for(int i = 0; i < n; i++) {
            if( students[i] == 0 ) {
                // 이전 번호한테 빌릴 수 있는 경우 
                if( i - 1 >= 0 && students[i-1] == 2 ) {
                    students[i-1] = 1;
                    students[i] = 1;
                }
                
                // 다음 번호한테 빌릴 수 있는 경우
                else if( i + 1 < n && students[i+1] == 2 ) {
                    students[i+1] = 1;
                    students[i] = 1;
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            if( students[i] >= 1 ) answer++;
        }
        return answer;
    }
}