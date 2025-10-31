import java.util.*;

class Solution {
    static char[] charArr;
    static int count = 0;
    static boolean[] visited;
    static HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        // 1. "17" -> { '1', '7' }
        charArr = numbers.toCharArray();
        
        visited = new boolean[charArr.length];
        
        // 2. DFS(현재 문자열, 문자열 배열, 방문 배열)
        DFS("", charArr, visited);
        
        // 3. set 순회하면서 소수 판별
        for(int a : set) {
            if( isPrime(a) ) count++;
        }
        
        return count;
    }
    
    public void DFS(String s, char[] c, boolean[] v) {
        // 1. 만들어진 숫자 추가
        if( !s.equals("") )
            set.add(Integer.parseInt(s));
        
        // 2. 반복문 동안 재귀 
        for(int i = 0; i < c.length; i++) {
            
            if( !visited[i] ) {
                visited[i] = true;
                String newS = s + (c[i] + "");
                DFS(newS, c, visited);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n) {      
        if ( n < 2 ) return false;
        
        for(int i = 2 ; i <= Math.sqrt(n); i++) {
            if( n % i == 0 ) return false;
        }
        
        return true;
    }
}