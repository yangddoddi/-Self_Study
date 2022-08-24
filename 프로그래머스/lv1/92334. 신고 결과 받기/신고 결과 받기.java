import java.util.*;
import java.io.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        //id_list : 이용자 ID
        // report : 신고한 이용자의 ID 정보 {이용자id 신고한id}
        // k : 정지 횟수 k
        // 반환값 : 이용자가 메일 받는 회수
        
        // 신고 당한 횟수는 map
        
        // report를 배열로 돌며 StringTokenizer로 문자열을 분리한다.
        // 토큰 1번째는 신고자, 2번째는 신고 당한자
        // 신고 당한자를 키, 신고한 자를 밸류로 넣음
        int[] answer = new int[id_list.length];
        Map<String, ArrayList<String>> result = new HashMap<>();
        Map<String, Integer> counter = new HashMap<>();
        StringTokenizer st;
        
        for ( String s : report ) {
            st = new StringTokenizer(s, " ");
            
            String reporter = st.nextToken();
            String reported = st.nextToken();
            
            if ( !result.containsKey(reporter) ) {
            result.put(reporter, new ArrayList<String>());
            }
            
            if ( !result.get(reporter).contains(reported) ) {
                result.get(reporter).add(reported);
                counter.put(reported, counter.getOrDefault(reported, 0) + 1);
            }
        }
        
        List<String> blackList = counter.keySet()
            .stream().filter( key -> counter.get(key) >= k)
            .collect(Collectors.toList());
        
            for (int i = 0; i < id_list.length; i++) {
                if (result.containsKey(id_list[i])) {
                    for ( String s : blackList) {
                        if (result.get(id_list[i]).contains(s)) {
                            answer[i]+=1;
                        }
                    }
                }
            }
        
        return answer;
        

        // 신고한 사람의 배열을 넣고
        // 배열 꺼내서 돌려서 2 이상이면 숫자체크하면 되겠네요
        
        // 신고 횟수 자체는 제한 x
        // 한 유저를 여러번 신고 가능하나 어차피 신고 횟수는 1회로 침
        // k번 이상 신고되면 정지되고, 신고한 유저에게 메일 발송됨
        
        
        // 신고한 유저 id , 유저가 신고한 id 기록
        // 유저별 신고당한 횟수 저장
        // 신고했는데 
    }
}