import java.util.*;

class Solution {          
    private Set<Set<String>> sets = new LinkedHashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        Set<String> set = new LinkedHashSet<>();
        dfs(user_id, banned_id, set);
        return sets.size();
    }
    
    private void dfs(String[] userIds, String[] bannedIds, Set<String> set) {
        if (set.size() == bannedIds.length) {
            if (isBannedList(set, bannedIds)) {
                sets.add(new HashSet<>(set));
            }
            
            return;
        }
        
        for (int i=0; i<userIds.length; i++) {
            if (set.add(userIds[i])) {
                dfs(userIds, bannedIds, set);
                set.remove(userIds[i]);
            }
        }
    }
    
    private boolean isBannedList(Set<String> set, String[] bannedIds) {
        int idx = 0;
        for (String s : set) {
            String bannedId = bannedIds[idx++];
            if (s.length() != bannedId.length()) return false;
            
            for (int i=0; i<s.length(); i++) {
                if (bannedId.charAt(i) == '*') continue;
                
                if (bannedId.charAt(i) != s.charAt(i)) return false;
            }
        }
        
        return true;
    }
}