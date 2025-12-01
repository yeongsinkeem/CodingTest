class Solution {
    int sCount = 0;
    
    public int solution(int n) {
        int fCount = 0;
        int next = n + 1;
        
        // 1. n의 1의 개수 
        while ( n > 1 ) {
            if( n % 2 == 1 ) fCount++;
            
            n = n / 2;
        }
        
        if( n == 1 ) fCount++;
        
        // 2. 그다음 N
        while ( true ) {
            int cnt = equalOne(next);
            
            if( cnt == fCount ) return next;
            
            next = next + 1;
        }
    }
    
    public int equalOne(int n) {
        sCount = 0;
        
        while ( n > 1 ) {
            if( n % 2 == 1 ) sCount++;
            
            n = n / 2;
        }
        
        if( n == 1 ) sCount++;
        
        return sCount;
    }
}