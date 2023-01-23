// 어떤 사원이 다른 사원보다 근태점수 / 동료점수 중 둘 다 낮은 경우가 있다면 인센티브를 못 받음
// 그렇지 않으면 두 점수 하원이 높은 순으로 석차를 내서 인센티브 지급함
// 두 점수 합이 동일하면 동석차, 동석차만큼 다음을 건너뜀
import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wonho = scores[0];
        
        Arrays.sort(scores, (a, b) -> {
            return (a[0] == b[0]) ? a[1] - b[1] : b[0] - a[0];
        });
        
        int maxScore = 0;
        int answer = 1;
        
        int w1 = wonho[0];  int w2 = wonho[1];  int wonhoScore = w1 + w2;
        for (int[] arr : scores) {
            int n1 = arr[0];
            int n2 = arr[1];
            int sum = n1 + n2;
            
            if (sum > wonhoScore && n2 >= maxScore) {
                answer++;
            }
            
            if (n1 == w1 && n2 == w2 && maxScore > w2) {
                return -1;
            }
            
            maxScore = Math.max(maxScore, n2);
        }
        
        return answer;
    }
}