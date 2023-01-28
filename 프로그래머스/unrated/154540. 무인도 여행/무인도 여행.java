import java.util.*;

class Solution {
    private int[] moveX = new int[]{1,-1,0,0};
    private int[] moveY = new int[]{0,0,1,-1};
    private List<Integer> list = new ArrayList<>();
    
    public int[] solution(String[] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        for (int i=0; i<maps.length; i++) {
            for (int j=0; j<maps[i].length(); j++) {
                if (visited[i][j]) continue; 
                if (maps[i].charAt(j) == 'X') continue;
                
                bfs(maps, new int[]{j, i}, visited);
            }
        }
        
        Collections.sort(list);
        
        return (list.size() == 0) ? new int[]{-1} : list.stream().mapToInt(e->e).toArray();
    }
    
    private void bfs(String[] maps, int[] start, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[1]][start[0]] = true;
        int temp = Integer.parseInt(String.valueOf(maps[start[1]].charAt(start[0])));
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for (int i=0; i<4; i++) {
                int nextX = current[0] + moveX[i];
                int nextY = current[1] + moveY[i];
                
                if (nextY >= maps.length || nextY < 0 || nextX >= maps[0].length() || nextX < 0) {
                    continue;
                }
                
                if (maps[nextY].charAt(nextX) == 'X') {
                    continue;
                }
                
                if (!visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    queue.add(new int[]{nextX, nextY});
                    temp += Integer.parseInt(String.valueOf(maps[nextY].charAt(nextX)));
                }
            }
        }
        
        list.add(temp);
    }
}