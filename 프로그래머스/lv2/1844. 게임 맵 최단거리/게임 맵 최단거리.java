import java.util.*;

class Solution {
    private int[] navX = new int[]{1,-1,0,0};
    private int[] navY = new int[]{0,0,1,-1};
    private int yLength;
    private int xLength;
    private int count = 1;
    
    public int solution(int[][] maps) {
        yLength = maps.length;
        xLength = maps[yLength-1].length;
        
        int[][] visited = new int[yLength][xLength];
        int answer = bfs(maps, visited);
        
        return answer;
    }
    
    private int bfs(int[][] maps, int[][] visited) {
        Queue<Integer> queue = new LinkedList<>();
        
        Integer x = 0;
        Integer y = 0;
        
        queue.add(x);
        queue.add(y);
        
        visited[y][x] = 1;
        
        while (!queue.isEmpty()) {
            x = queue.poll();
            y = queue.poll();
            
            for (int i=0; i<navX.length; i++) {
                Integer nextX = x + navX[i];
                Integer nextY = y + navY[i];
                
                if (nextX < 0 || nextX >= maps[0].length) {
                    continue;
                }
                
                if (nextY < 0 || nextY >= maps.length) {
                    continue;
                }
                
                if (maps[nextY][nextX] == 0) {
                    continue;
                }
                
                if (visited[nextY][nextX] == 0) {
                    queue.add(nextX);
                    queue.add(nextY);
                    visited[nextY][nextX] = visited[y][x]+1;
                    count++;
                }
                
                if (nextY == yLength-1 && nextX == xLength-1) {
                    return visited[nextY][nextX];
                }
            }
        }
        
        return -1;
    }
}