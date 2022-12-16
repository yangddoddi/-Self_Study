import java.util.*;

class Solution {
    // 하드 디스크를 가장 효율적이게 순서대로 처리하는 방법?
    // 끝나는 시점이 빠른 것부터 순차적으로 돌리자
    
    // 구해야하는 값 = 소수점을 제외한 작업 요청부터 걸린 시간까지의 평균
    
    // 중요 : 하드디스크가 쉬는 동안에는 무조건 시작이 빠른 게 장땡임
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int answer = 0;
        int count = 0;
        int idx = 0;
        int end = 0;
        
        while (count < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= end) {
                queue.add(jobs[idx++]);
            }
            
            if (queue.isEmpty()) {
                end = jobs[idx][0];
            } else {
                int[] job = queue.poll();
                answer += job[1] + end - job[0];
                end += job[1];
                count++;
            }
        }
        
        return answer/jobs.length;
    }
}