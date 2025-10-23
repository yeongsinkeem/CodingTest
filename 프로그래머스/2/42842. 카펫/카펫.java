class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow;
        
        for(int i = 1; i <= total; i++) {
            if(total % i == 0) {
                int width = i;
                int height = total / i;
                
                // 일자 직사각형인지, 블럭형 직사각형인지 확인 
                if( (width - 2) * (height -2) == yellow ) {
                    if(width >= height) {
                        answer[0] = width;
                        answer[1] = height;
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}