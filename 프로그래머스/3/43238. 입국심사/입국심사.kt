class Solution {
    fun solution(n: Int, times: IntArray): Long {
        val min = 1L
        val max = 1_000_000_000_000_000_000L
        
        return binarySearch(
            min = min,
            max = max,
            times = times,
            people = n
        )
    }
    
    fun binarySearch(
        min: Long,
        max: Long,
        times: IntArray,
        people: Int
    ): Long {
        var left = min
        var right = max
        var mid = 0L
        var minValue = Long.MAX_VALUE
        
        while (left <= right) {
            mid = (left + right) / 2
        
            var cnt = 0L
            for (i in times.indices) {
                cnt += (mid / times[i])
            }
            
            if (cnt >= people) {
                right = mid - 1
                minValue = Math.min(mid, minValue)
            }
            
            if (cnt < people) {
                left = mid + 1
            }
        }
        
        return minValue
    }
}