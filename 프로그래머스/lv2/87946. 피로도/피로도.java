class Solution {
    private static int max = 0;
    // 최소 필요 피로도 == 던전을 탐험하기 위한 최소한의 피로도
    // 소모 피로도 == 던전을 탐험한 후 소모되는 피로도
    
    // dungeons[idx][0] = 최소 필요 피로도
    // dungeons[idx][1] = 소모 피로도
    public int solution(int k, int[][] dungeons) {
        boolean[] visited;
        for (int i=0; i<dungeons.length; i++) {
                visited = new boolean[dungeons.length];
                dfs(i, visited, k, dungeons, 0);
        }
        
        return max;
    }
    
    private void dfs(int idx, boolean[] visited, int nowFatigue, int[][] dungeons, int count) {
        visited[idx] = true;
        
        if (nowFatigue >= dungeons[idx][1]) {
            nowFatigue -= dungeons[idx][1];
            count += 1;
        } else {
            return;
        }
        
        max = Math.max(max, count);
        
        for (int i=0; i<dungeons.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            if (nowFatigue >= dungeons[i][0]) {
                visited[i] = true;
                dfs(i, visited, nowFatigue, dungeons, count);
                visited[i] = false;
            }
        }
    }
}