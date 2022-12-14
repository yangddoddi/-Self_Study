import java.util.*;

class Solution {
    //priorities : 각 문서와 중요도
    //location : 몇 번째로 인쇄되는지 알아야하는 문서
    //문제점 ? 중요도가 같을 경우 다소 난해해진다
    public int solution(int[] priorities, int location) {
        Queue<Doc> queue = new PriorityQueue<>(
        (o1, o2) -> o2.priority - o1.priority);
        
        for (int i=0; i<priorities.length; i++) {
            queue.add(new Doc(i, priorities[i]));
        }
        
        int cnt = 1;
        
        while (!queue.isEmpty()) {
            for (int i=0; i<priorities.length; i++) {
                if (priorities[i] == queue.peek().priority) {
                    Doc doc = queue.poll();
                    
                    if (i == location) { 
                        return cnt;
                    }
                    
                    cnt++;
                }
            }
        }
        
        return 0;
    }
    
    class Doc {
        int idx;
        int priority;
        
        public Doc(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}