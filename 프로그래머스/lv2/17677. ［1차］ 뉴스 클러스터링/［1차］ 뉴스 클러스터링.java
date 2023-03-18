import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        if (str1.equals(str2)) return 65536;
        
        List<String> setA = new ArrayList<>();
        List<String> setB = new ArrayList<>();
        
        getSet(setA, str1);
        getSet(setB, str2);
        
        int aSize = setA.size();
        int bSize = setB.size();
        
        List<String> intersection = new ArrayList<>();
        for (String s : setA) {
            if (setB.contains(s)) {
                intersection.add(s);
                setB.remove(s);
            }
        }
        
        double similarity = (double)intersection.size() / (double)(aSize + bSize - intersection.size());
        
        return (aSize == 0 && bSize == 0) ? 65536 : (int)(similarity * 65536);
    }
    
    private void getSet(List<String> list, String str) {
        for (int i=0; i<str.length(); i++) {
            if (i == str.length()-1) break;
            
            char charA = str.charAt(i);
            char charB = str.charAt(i+1);
            
            if (charA > 'z' || charA < 'a' || charB > 'z' || charB < 'a') {
                continue;
            }
            
            list.add(String.valueOf(charA) + String.valueOf(charB));
        }
    }
}