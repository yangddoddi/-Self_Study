class Solution {
    public String solution(String s) {
        String[] input = s.split(" ");
        StringBuilder answer = new StringBuilder();
        for (int i=0; i<input.length; i++) {
            String[] sub = input[i].split("");
            answer.append(sub[0].toUpperCase());
            
            for (int j=1; j<sub.length; j++) {
                answer.append(sub[j].toLowerCase());
            }
            
            if (i != input.length-1) {
                answer.append(" ");
            }
        }
        
        if (s.charAt(s.length()-1) == ' ') {
            answer.append(" ");
        }
        
        return answer.toString();
    }
}