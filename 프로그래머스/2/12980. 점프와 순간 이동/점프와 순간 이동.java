import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        int rem = 0;
        
        if(n % 2 != 0) ans++;
        
        while( n / 2 > 0 ) {
            n = n / 2;
            rem = n % 2;

            if( n == 1 || rem == 1 ) {
                ans++;
            }
        }
        return ans;
    }
}