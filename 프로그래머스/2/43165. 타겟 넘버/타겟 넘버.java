class Solution {
    int[] numbers;
    int target;
    int answer;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        answer = 0;
        
        DFS(0, 0, numbers);
        
        return answer;
    }
    
    public void DFS(int depth, int sum, int[] num) {
        
        if(depth == numbers.length) {
            if(sum == target) answer++;
            return;
        }
        
        DFS(depth + 1, sum + num[depth], num);
        DFS(depth + 1, sum - num[depth], num);
    }
}