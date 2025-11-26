import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 나머지들은 Stack 영역에
        Stack<Integer> s = new Stack<>();
        
        // 1. 3진법으로 만들기 
        // 몫이 0보다 클 때까지 
        while( n > 0 ) {
            int rem = n % 3;
            n = n / 3;
            
            s.push(rem);
        }
        
        // 2. 앞뒤 반전 
        List<Integer> revArr = new ArrayList<>();
        for(int a : s) {
            revArr.add(a);
        }
        Collections.reverse(revArr);
        
        // 3. 10진법으로 표현 
        int sum = 0;
        
        int idx = 0;
        for(int i : revArr) {
            sum += i * Math.pow(3, idx++);
        }
        
        
        return sum;
    }
}