import java.util.*

class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        val edgeList = mutableListOf<MutableList<Int>>()
        
        for (i in 0 .. n) {
            edgeList.add(mutableListOf())
        }
        
        for (i in edge.indices) {
            val nodeA = edge[i][0]
            val nodeB = edge[i][1]
            
            edgeList[nodeA].add(nodeB)
            edgeList[nodeB].add(nodeA)
        }
        
        val distanceArray = dijkstra(
            edgeList,
            1,
            n
        )
        
        var maxValue = Int.MIN_VALUE
        
        for (i in distanceArray.indices) {
            maxValue = Math.max(distanceArray[i], maxValue)
        }
        
        return distanceArray.filter { it == maxValue }.count()
    }
    
    fun dijkstra(
        edgeList: MutableList<MutableList<Int>>,
        start: Int,
        nodeCount: Int
    ): IntArray {
        val queue = PriorityQueue<Node>() {
            a, b -> b.distance - a.distance
        }
        queue.add(Node(start, 0))
        
        val distanceArray = IntArray(nodeCount + 1) {
            Int.MAX_VALUE
        }
        distanceArray[0] = 0
        distanceArray[start] = 0
        
        while (queue.isNotEmpty()) {
            val currNode = queue.poll()
            
            if (currNode.distance > distanceArray[currNode.nodeNumber]) {
                continue
            }
            
            for (i in edgeList[currNode.nodeNumber].indices) {
                val nextDistance = currNode.distance + 1
                val nextNode = Node(edgeList[currNode.nodeNumber][i], nextDistance)
                
                if (nextDistance < distanceArray[nextNode.nodeNumber]) {
                    queue.add(nextNode)
                    distanceArray[nextNode.nodeNumber] = nextDistance
                }
            }
        }
        
        return distanceArray
    }
    
    data class Node(
        val nodeNumber: Int,
        val distance: Int
    )
}