class Solution {
    // 앞자리가 무조건 커야함
    // 뒷자리에 더이상 선택지가 없다면 뭐라도 넣어야함
    
    // number = 원본 수
    // k = 제거할 수
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        // 만들어야하는 자리수 = number.length - k
        int goal = number.length() - k;
        // 현재 만들고 있는 자리수 = i
        // idx = 시작할 인덱스
        int idx = 0;
        
        for (int i=0; i<goal; i++) {
            int max = Character.getNumericValue(number.charAt(idx));
            
            for (int j=idx; j<number.length()-(goal-i)+1; j++) {
                int prev = max;
                int cur = Character.getNumericValue(number.charAt(j));
                
                if (cur == 9) {
                    max = cur;
                    idx = j;
                    break;
                }
                
                if (cur > prev) {
                    max = cur;
                    idx = j;
                }
            }
            
            sb.append(max);
            idx++;
        } 
        
        return sb.toString();
    }
}