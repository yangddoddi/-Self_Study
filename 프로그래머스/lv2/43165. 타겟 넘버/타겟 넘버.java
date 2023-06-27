class Solution {
    private int answer = 0;
    
    public int solution(int[] numbers, int target) {
        int[][] arr = new int[numbers.length][4];
        
        dfs(numbers[0] * 1, 1, target, numbers);
        dfs(numbers[0] * -1, 1, target, numbers);
        
        return answer;
    }
    
    public void dfs(int current, int idx, int target, int[] numbers) {
        if (idx == numbers.length && current == target) {
            answer++;
            return;
        }
        
        if (idx == numbers.length) return;
        
        dfs(current + numbers[idx], idx+1, target, numbers);
        dfs(current - numbers[idx], idx+1, target, numbers);
    }
}