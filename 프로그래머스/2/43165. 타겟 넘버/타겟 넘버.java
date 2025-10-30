class Solution {
    int[] numbers;
    int target;
    int count = 0;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        this.numbers = numbers;
        this.target = target;
        
        // 1. 재귀 호출 
        DFS(0, 0);
        return count;
    }
    
    public void DFS(int sum, int idx) {
        // 1. 종료조건
        if( idx == numbers.length ) {
            if( sum == target ) {
                count++;
            }
            return;
        }
        
        DFS(sum + numbers[idx], idx + 1);
        DFS(sum - numbers[idx], idx + 1);
    }
}