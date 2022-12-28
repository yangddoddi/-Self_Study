import java.util.*;

class Solution {
    // people - 사람 몸무게 담긴 배열
    // limit - 구명 보트 무게 제한
    // 반환값 - 모든 사람을 구하기 위한 구명보트 개수의 최소값
    
    // 작은 무게 + 큰무게를 더하면 좋다
    // 만약 큰무게 + 작은 무게를 합쳐서 안된다면 큰 무게는 혼자 타야한다
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        LinkedList<Integer> peopleList = new LinkedList<>();
        
        for (int p : people) {
            peopleList.add(p);
        }
        
        int answer = 0;
        while (peopleList.size() != 0) {
            if (peopleList.peekFirst() + peopleList.peekLast() <= limit) {
                peopleList.pollFirst();
            } 
            peopleList.pollLast();
            answer++;
        }
        
        return answer;
    }
}