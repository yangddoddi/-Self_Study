class Solution {
    public int[] solution(String s) {
        int convertCount = 0;
        int zeroCount = 0;
        
        while (!s.equals("1")) {
            StringBuilder sb = new StringBuilder();
        
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '1') sb.append(1);
                
                if (s.charAt(i) == '0') zeroCount++;
            }
        
            int length = sb.length();
            s = Integer.toBinaryString(length);
            
            convertCount++;
        }
        
        return new int[]{convertCount, zeroCount};
    }
}