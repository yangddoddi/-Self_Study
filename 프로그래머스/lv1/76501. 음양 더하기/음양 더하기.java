class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int result = 0;
        for (int i=0; i<absolutes.length; i++) {
            if (!signs[i]) { absolutes[i] *= -1; }
            result += absolutes[i];
        }
        return result;
    }
}