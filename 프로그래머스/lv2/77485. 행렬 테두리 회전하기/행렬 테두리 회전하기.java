import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows+1][columns+1];
        for (int i=1; i<=rows; i++) {
            for (int j=1; j<=columns; j++) {
                map[i][j] = j + (columns * (i-1));
            }
        }
        
        int[] answers = new int[queries.length];
        int idx = 0;
        for (int[] q : queries) {
            answers[idx++] = rotate(map, q);
        }
        
        return answers;
    }
    
    public int rotate(int[][] map, int[] query) {
        int left = query[1];
        int right = query[3];
        int top = query[0];
        int bottom = query[2];
        int firstNum = map[top][right];
        int min = Integer.MAX_VALUE;

        // 위 이동
        for (int i=top; i<=top; i++) {
            for (int j=right; j>left; j--) {
                map[i][j] = map[i][j-1];
                min = Math.min(map[i][j], min);
            }
        }
        
        // 좌 이동
        for (int i=top; i<bottom; i++) {
            for (int j=left; j<=left; j++) {
                map[i][j] = map[i+1][j];
                min = Math.min(map[i][j], min);
            }
        }
        
        // 아래 이동
        for (int i=bottom; i<=bottom; i++) {
            for (int j=left; j<right; j++) {
                map[i][j] = map[i][j+1];
                min = Math.min(map[i][j], min);
            }
        }
        
        // 우 이동
        for (int i=bottom; i>top+1; i--) {
            for (int j=right; j<=right; j++) {
                map[i][j] = map[i-1][j];
                min = Math.min(map[i][j], min);
            }
        }
        
        // 끼워넣기
        map[top+1][right] = firstNum;
        min = Math.min(firstNum, min);
        
        return min;
    }
}