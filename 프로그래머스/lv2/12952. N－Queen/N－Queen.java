
class Solution {
    private static int answer = 0;
    private static int[] board;
    
    public int solution(int n) {
        board = new int[n];
        
        nQueen(0, n);
        
        return answer;
    }
    
    public void nQueen(int depth, int n) {       
        if (depth == n) {
            answer++;
            return;
        }
        
        for (int i=0; i<n; i++) {
            board[depth] = i;
            
            if (isPossible(depth)) {
                nQueen(depth+1, n);
            }
        }
    }
    
    public boolean isPossible(int col) {
        for (int i=0; i<col; i++) {
            if (board[i] == board[col]) return false;

            if (Math.abs(col - i) == Math.abs(board[col] - board[i])) return false;
        }
        
        return true;
    }
}