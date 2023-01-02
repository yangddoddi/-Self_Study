import java.util.*;

class Solution {
    private int[] moveX = {1,-1,0,0};
    private int[] moveY = {0,0,1,-1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {        
        int[][] map = new int[101][101];
        
        for (int i=0; i<rectangle.length; i++) {
            rectangle[i][0] = rectangle[i][0] * 2;
            rectangle[i][1] = rectangle[i][1] * 2;
            rectangle[i][2] = rectangle[i][2] * 2;
            rectangle[i][3] = rectangle[i][3] * 2;
            
            for (int j=rectangle[i][1]; j<=rectangle[i][3]; j++) {
                for (int k=rectangle[i][0]; k<=rectangle[i][2]; k++) {
                    map[j][k] = 1;
                }
            }
        }
        
        for (int i=0; i<rectangle.length; i++) {
            for (int j=rectangle[i][1]+1; j<rectangle[i][3]; j++) {
                for (int k=rectangle[i][0]+1; k<rectangle[i][2]; k++) {
                    map[j][k] = 0;
                }
            }
        }
        
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        int[][] visited = new int[101][101];
        bfs(map, visited, characterX, characterY, itemX, itemY);
        
        return visited[itemY][itemX]/2;
    }
        
        
        private void bfs(int[][] map, int[][] visited, int characterX, int characterY, int itemX, int itemY) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{characterY,characterX});
            visited[characterY][characterX] = 0;
            
            while (!queue.isEmpty()) {
                int[] arr = queue.poll();
                
                for (int i=0; i<moveX.length; i++) {
                    int x = arr[1];
                    int y = arr[0];
                    
                    int nextX = x + moveX[i];
                    int nextY = y + moveY[i];
                    
                    if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY == map[0].length) continue;
                    
                    if (visited[nextY][nextX] != 0) continue;
                    
                    if (map[nextY][nextX] != 1) continue;
                    
                    visited[nextY][nextX] = visited[y][x] + 1;
                    queue.add(new int[]{nextY, nextX});
                    
                    if (nextX == itemX && nextY == itemY) return;
                }
            }
        }
     }