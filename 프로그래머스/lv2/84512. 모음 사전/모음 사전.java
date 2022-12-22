import java.util.*;

class Solution {
    public static int answer = 0;
    // 조합 완전 탐색
    // A -> AA -> AAA -> AAAA -> AAAAA -> AAAAE -> AAAAI -> ..
    public int solution(String word) {
        String[] alphabet = new String[]{"A","E","I","O","U"};
        
        Set<String> set = new HashSet<>();
        for (int i=0; i<alphabet.length; i++) {
            dfs(set, alphabet, alphabet[i], word);
            if (answer != 0) break;
        }
        
        return answer;
    }
    
    public void dfs(Set<String> set, String[] alphabet, String current, String word) {
        set.add(current);
        
        if (current.equals(word)) {
            answer = set.size();
            return;
        }
        
        if (current.length() == 5) return;
        
        for (int i=0; i<alphabet.length; i++) {
            String next = alphabet[i];
            
            if (set.contains(current + next)) continue;
            
            dfs(set, alphabet, current + next, word);
            
        }
    }
}