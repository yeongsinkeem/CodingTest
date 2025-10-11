class Solution {
    int answer = 0;
    int[] numbers;
    int target;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        // 1. DFS 시작 
        DFS(0, 0);
        
        return answer;
    }
    
    public void DFS(int idx, int sum) {
        // 종료 조건 
        if(idx == numbers.length) {
            if(sum == target) answer++;
            return;
        }
        
        DFS(idx + 1, sum + numbers[idx]);
        DFS(idx + 1, sum - numbers[idx]);
        
    }
}