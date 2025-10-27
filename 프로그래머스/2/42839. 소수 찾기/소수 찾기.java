import java.util.*;

class Solution {
    HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        
        // 1. "011" -> "0", "1", "1"
        char[] numsArr = numbers.toCharArray();
        boolean[] visited = new boolean[numsArr.length];
        
        DFS("", numsArr, visited);
        
        for(int num : set) {
            if( isPrime(num) ) answer++;
        }
        
        return answer;
    }
    
    public void DFS(String str, char[] arr, boolean[] visited){
        if( !str.equals("") ) set.add(Integer.parseInt(str));
        
        for(int i = 0 ; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                DFS(str + arr[i], arr, visited);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n) {
        if ( n < 2 ) return false;
        
        for(int i = 2; i <= (int)Math.sqrt(n); i++) {
            if( n % i == 0 ) return false;
        }
        return true;
    }
}