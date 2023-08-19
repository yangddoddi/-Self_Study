import java.util.*

class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        val orderedJobs: MutableList<IntArray> = jobs
            .toList()
            .sortedWith(compareBy ({ it[0] }, { -it[1] }))
            .toMutableList()
            
        val delayTimePriorityQueue: PriorityQueue<IntArray> = PriorityQueue() {
            a, b -> 
            if (a[1] != b[1]) {
                a[1] - b[1]
            } else a[0] - b[0]
        }
            
        var idx: Int = 0
        var time: Int = 0
        var endTime: Int = 0
        var count: Int = 0
        
        while (count < orderedJobs.size) {
            while (idx < orderedJobs.size && orderedJobs[idx][0] <= endTime) {
                delayTimePriorityQueue.add(orderedJobs[idx++])
            }
            
            if (delayTimePriorityQueue.isEmpty()) {
                endTime = orderedJobs[idx][0]
            }
            
            if (!delayTimePriorityQueue.isEmpty()) {
                val currentJob: IntArray = delayTimePriorityQueue.poll()
                println(currentJob.toList().toString())
                
                time += (endTime - currentJob[0]) + currentJob[1]
                endTime += currentJob[1]
                println("endTime : $endTime currentJob[0] : $currentJob[0] currentJob[1] : $currentJob[1] => time = $time")
                count++
            }
        }
        
        return time / jobs.size
    }
}