import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        Queue<Integer> aQueue = new PriorityQueue<>((a,b) -> a-b);
        Queue<Integer> bQueue = new PriorityQueue<>((a,b) -> b-a);
        
        for (int i=0; i<A.length; i++) {
            aQueue.add(A[i]);
            bQueue.add(B[i]);
        }
        
        int answer = 0;
        
        while (!aQueue.isEmpty()) {
            answer += (aQueue.poll() * bQueue.poll());
        }
        
        return answer;
    }
}