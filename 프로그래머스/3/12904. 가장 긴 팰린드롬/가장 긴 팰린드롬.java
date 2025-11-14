class Solution
{
    int maxLen = 1;
    
    public int solution(String s)
    {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++) {
            // 1. 짝수 palindrome -> abba
            isPalindrome(s, i, i+1);
            
            // 2. 홀수 palindrome -> abcba
            isPalindrome(s, i, i);
        }
        return maxLen;
    }
    
    public void isPalindrome(String str, int left, int right) {
        // 범위 만족 + 대칭이어야 함
        while( left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right) ) {
            maxLen = Math.max(maxLen, right - left + 1);
            
            left --;
            right ++;
        }
    }
}