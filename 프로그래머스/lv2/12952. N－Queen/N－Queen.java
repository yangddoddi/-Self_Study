class Solution {
    private int answer;
    private int[] board;
    
    public int solution(int n) {
        board = new int[n];
        nQueen(0, n);
        return answer;
    }
    
    private void nQueen(int depth, int n) {
        if (depth == n) {
            answer += 1;
            return;
        }
        
        for (int i=0; i<n; i++) {
            board[depth] = i;
            
            if (isPossible(depth)) {
                nQueen(depth+1, n);
            }
        }
    }
    
    private boolean isPossible(int col) {
        for (int i=0; i<col; i++) {
            if (board[i] == board[col]) return false;
            
            if (Math.abs(col-i) == Math.abs(board[col]-board[i])) return false;
        }
        
        return true;
    }
}