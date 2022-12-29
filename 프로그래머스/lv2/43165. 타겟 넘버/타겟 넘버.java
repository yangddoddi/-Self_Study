class Solution {
    private static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        
        return answer;
    }
    
    private void dfs(int[] numbers, int curr, int idx, int target) {
        if (idx == numbers.length) {
            if (curr == target) { 
                answer += 1;
            }
            return;
        }
        
        dfs(numbers, curr, idx+1, target + numbers[idx]);
        dfs(numbers, curr, idx+1, target - numbers[idx]);
    }
}