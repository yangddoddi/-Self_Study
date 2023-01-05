class Solution {
    public long solution(int n, int[] times) {
        return binarySearch(times, (long)times[0], (long)times[times.length-1] * n, n);
    }
    
    private long binarySearch(int[] times, long row, long high, int target) {
        long l = (long)row;
        long r = (long)high;
        
        long sum = 0;
        long answer = 0;
        while (l <= r) {
            long m = (l+r) / 2;
            
            sum = 0;
            for (int t : times) {
                sum += (m/t);
            }
            
            if (target > sum) l = m+1;
            
            if (target <= sum) {
                r = m-1;
                answer = m;
            }
        }
        
        return answer;
    }
}