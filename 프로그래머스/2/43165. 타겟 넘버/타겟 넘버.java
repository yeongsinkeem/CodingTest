class Solution {
    private int[] numbers;
    public static int sum = 0;
    
    private int target;
    private int count = 0;
    private int total = 0;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        this.numbers = numbers;
        this.target = target;
        
        // DFS(시작 노드, 현재 합)
        DFS(0, 0);
        
        return count;
    }
    
    public void DFS(int node, int sum) {
        // 종료 조건 
        if(node == numbers.length ) {
            if(sum == target) {
                count++;
                
            }
        return;
    }
        
        DFS(node + 1, sum + numbers[node]);
        DFS(node + 1, sum - numbers[node]);
    }
}