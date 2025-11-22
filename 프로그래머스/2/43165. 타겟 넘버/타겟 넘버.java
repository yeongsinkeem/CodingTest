class Solution {
    int currSum = 0;
    int answer = 0;
    int target = 0;
    int[] numbers;
    
    public int solution(int[] numbers, int target) {
        this.target = target;
        this.numbers = numbers;
        
        DFS(currSum, 0);
        return answer;
    }
    
    public void DFS(int sum, int depth) {
        if( depth == numbers.length ) {
            if( sum == target ) {
                answer++;
            }
            return;
        }
        
        DFS(sum + numbers[depth], depth + 1);
        DFS(sum - numbers[depth], depth + 1);
    }
}