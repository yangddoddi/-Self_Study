import java.util.LinkedList
import java.util.PriorityQueue

fun main(args: Array<String>) {
    val testCaseCount = readln().toInt()

    val answer = StringBuilder()
    for (i in 0 until testCaseCount) {
        val targetIdx = readln().split(" ")[1].toInt()
        val queueingList = readln()
            .split(" ")
            .map { it.toInt() }

        val printerQueue = LinkedList<QueueingData>()
        queueingList.forEachIndexed { idx, priority ->
            printerQueue.addLast(
                QueueingData(
                    initialIdx = idx,
                    priority = priority
                )
            )
        }

        val priorityQueue = PriorityQueue<QueueingData> { a, b ->
            b.priority - a.priority
        }.apply {
            this.addAll(printerQueue)
        }

        var count = 1
        while (true) {
            val data = printerQueue.poll()
            val maxPriorityData = priorityQueue.poll()

            when {
                (data.priority == maxPriorityData.priority) && (data.initialIdx == targetIdx) -> {
                    answer.append("$count\n")
                    break
                }
                (data.priority == maxPriorityData.priority) -> {
                    count++
                    continue
                }
                else -> {
                    printerQueue.addLast(data)
                    priorityQueue.add(maxPriorityData)
                }
            }
        }
    }

    println(answer)
}

data class QueueingData(
    val initialIdx: Int,
    val priority: Int
)