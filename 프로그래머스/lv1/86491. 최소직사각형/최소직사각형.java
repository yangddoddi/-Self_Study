class Solution {
    public int solution(int[][] sizes) {
        int min = 0;
        int max = 0;
        
        int maxMin = 0;
        int maxMax = 0;
        
        for (int i=0; i<sizes.length; i++) {
            max = Math.max(sizes[i][0], sizes[i][1]);
            min = Math.min(sizes[i][0], sizes[i][1]);
            
            maxMin = Math.max(maxMin, min);
            maxMax = Math.max(maxMax, max);
        }
        
        return maxMin * maxMax;
    }
}