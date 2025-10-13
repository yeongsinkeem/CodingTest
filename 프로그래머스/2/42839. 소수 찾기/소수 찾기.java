import java.util.*;

class Solution {
    HashSet<Integer> numberSet = new HashSet<>();
    
    // 소수 판별 메소드
    public boolean isPrime(int num) {
        if(num < 2) {
            return false;
        }
        for(int i = 2; i <= (int) Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    
    // DFS로 모든 숫자 조합 만들기 
    public void DFS(String currentNum, char[] numbersArr, boolean[] visited) {
        // 문자가 있다면 
        if(!currentNum.equals("")) numberSet.add(Integer.parseInt(currentNum));
        
        for(int i = 0; i < numbersArr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                DFS(currentNum + numbersArr[i], numbersArr, visited);
                visited[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        int answer = 0;
        
        char[] numbersArr = numbers.toCharArray();
        boolean[] visited = new boolean[numbersArr.length];
        
        DFS("", numbersArr, visited);
        
        for(int num : numberSet) {
            if( isPrime(num) ) answer++;
        }
        
        return answer;
    }
 
}