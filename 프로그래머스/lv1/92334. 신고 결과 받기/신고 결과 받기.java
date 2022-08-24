import java.util.*;
import java.io.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, User> users = new HashMap<>();
        int[] answer = new int[id_list.length];
        
        for ( int i=0; i<id_list.length; i++ ) {
            users.put(id_list[i],new User(i));
        }
        
        StringTokenizer st = null;
        for ( String str : report ) {
            st = new StringTokenizer(str, " ");
            
            String reporter = st.nextToken();
            String reported = st.nextToken();
            
            users.get(reported).BeReported(reporter);
        }
        
        for ( String str : id_list ) {
            users.get(str).checkReportedCount(k, users);
        }
        
        for ( int i=0; i<id_list.length; i++ ) {
            answer[i] = users.get(id_list[i]).getEmailCount();
        }
        
        return answer;
    }
    
    class User {
        private int emailCount;
        private int idx;
        private Set<String> reportedRecord;
        
        public User (int idx) {
            this.idx = idx;
            this.emailCount = 0;
            this.reportedRecord = new HashSet<>();
        }

        public void incraseEmailCount() {
            this.emailCount += 1;
        }
        
        public int getEmailCount() {
            return this.emailCount;
        }
        
        public void BeReported(String userName) {
            reportedRecord.add(userName);
        }
        
        public void checkReportedCount(int condition, Map<String,User> users) {
            if (reportedRecord.size() >= condition) {
                reportedRecord.stream()
                    .forEach(e-> users.get(e).incraseEmailCount());
            }
        }
    }
}