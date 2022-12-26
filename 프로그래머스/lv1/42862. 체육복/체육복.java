import java.util.*;
import java.util.stream.*;

class Solution {
    // 전체 학생 n
    // 도난당한 학생 lost
    // 여벌 체육벅 가진 학생 reserve
    
    // 체육 수업 들을 수 있는 학생 최대값?
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = Arrays
            .stream(lost)
            .boxed()
            .sorted()
            .collect(Collectors.toList());
        
        List<Integer> reserveList = Arrays
            .stream(reserve)
            .boxed()
            .sorted()
            .collect(Collectors.toList());
        
        List<Integer> duplication = lostList
            .stream()
            .filter(e -> reserveList.contains(e))
            .collect(Collectors.toList());
        
        for (int i=0; i<duplication.size(); i++) {
            lostList.remove(duplication.get(i));
            reserveList.remove(duplication.get(i));
        }
        
        int answer = n - lostList.size();
        
        for (int i=0; i<lostList.size(); i++) {
            int l = lostList.get(i);
            
            if (reserveList.contains(l-1)) {
                answer ++;
                reserveList.remove(reserveList.indexOf(l-1));
            } else if (reserveList.contains(l+1)) {
                answer ++;
                reserveList.remove(reserveList.indexOf(l+1));
            }
        }
        
        return answer;
    }
}