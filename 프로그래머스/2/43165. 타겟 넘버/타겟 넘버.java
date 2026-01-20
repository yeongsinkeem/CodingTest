class Solution {
    static int[] numbers;
    static int target;
    static int count;
    
    public int solution(int[] numbers, int target) {
        count = 0;
        this.numbers = numbers;
        this.target = target;
        
        // DFS(현재 idx, sum) 전달
        DFS(0, 0, target);
        
        return count;
    }
    
    public void DFS(int idx, int curr, int target) {
        if( idx == numbers.length ) {
            if( curr == target ) count++;
    
            return;
        }
        
        DFS(idx + 1, curr + numbers[idx], target);
        DFS(idx + 1, curr - numbers[idx], target);
        
        
    }
}