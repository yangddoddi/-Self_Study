class Solution {
    private int answer = 0;
    
    public int solution(int[] stones, int k) {
        int min = 0;
        int max = 200_000_000;
        
        binarySearch(min, max, stones, k);
        return answer;
    }
    
    private void binarySearch(int min, int max, int[] stones, int k) {
        int l = min;
        int r = max;
        
        while (l <= r) {
            int mid = (l+r) / 2;
            
            if (validate(mid, stones, k)) {
                answer = Math.max(mid, answer);
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
    }
    
    private boolean validate(int friends, int[] stones, int k) {
        int temp = 0;
        for (int stone : stones) {
            if (stone < friends) {
                temp++;
            } else {
                temp = 0;
            }
            
            if (temp == k) {
                return false;
            }
        }
        
        return true;
    }
}