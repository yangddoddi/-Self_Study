class Solution {
    private int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        backtracking(words, begin, target, visited, 0);
        return (answer == Integer.MAX_VALUE) ? 0 : answer;
    }
    
    private void backtracking(String[] words, String current, String target, boolean[] visited, int count) {
        if (current.equals(target)) {
            answer = Math.min(answer, count);
        }
        
        for (int i=0; i<words.length; i++) {
            if (!matchWord(words[i], current)) continue;
            
            if (visited[i]) continue;
            
            visited[i] = true;
            backtracking(words, words[i], target, visited, count+1);
            visited[i] = false;
        }
    }
    
    private boolean matchWord(String beign, String target) {
        int count = 0;
        for (int i=0; i<beign.length(); i++) {
            if (target.charAt(i) == beign.charAt(i)) count++;
        }
        
        return (count == beign.length()-1) ? true : false;
    }
}