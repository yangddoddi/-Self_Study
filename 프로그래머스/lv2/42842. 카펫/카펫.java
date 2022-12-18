class Solution {
    // brown + yello = x
    // width * height = x
    // yellow = (width-2) * (height-2)
    // brown = width * height - yellow
    // 단, witdth >= height
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        
        int[] answer = new int[2];
        getAnswer(answer, sum, yellow);
        
        return answer;
    }
    
    private void getAnswer(int[] answer, int sum, int yellow) {
        for (int i=2; i<sum; i++) {
            if (sum%i == 0) {
                int width = Math.max(sum/i, i);
                int height = Math.min(sum/i, i);
                
                if ((width-2) * (height-2) == yellow) {
                    answer[0] = width;
                    answer[1] = height;
                }
            }
        }
    }
}