import java.util.*

class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        val edges = mutableListOf<MutableList<Int>>()
        
        for (i in 0 .. n) {
            edges.add(mutableListOf())
        }
        
        for (i in edge.indices) {
            val nodeA = edge[i][0]
            val nodeB = edge[i][1]
            
            edges[nodeA].add(nodeB)
            edges[nodeB].add(nodeA)
        }
        
        val distanceList = dijkstra(1, n, edges)
        var maxDistance = Int.MIN_VALUE
        for (i in distanceList.indices) {
            if (distanceList[i] == Int.MAX_VALUE) continue
            
            maxDistance = Math.max(distanceList[i], maxDistance)
        }
        
        return distanceList.filter { it == maxDistance }.count()
    }
    
    fun dijkstra(
        startNode: Int,
        nodeCount: Int,
        edges: MutableList<MutableList<Int>>
    ): IntArray {
        val queue = PriorityQueue<Node>() {
            a, b -> b.distance - a.distance
        }
        
        val distanceArray = IntArray(nodeCount + 1)
        
        for (i in distanceArray.indices) {
            distanceArray[i] = Int.MAX_VALUE
        }
        
        distanceArray[startNode] = 0
        queue.add(Node(startNode, 0))
        
        while (queue.isNotEmpty()) {
            val currNode = queue.poll()
            
            for (i in edges[currNode.number].indices) {
                val nextNodeNumber = edges[currNode.number][i]
                val nextDistance = distanceArray[currNode.number] + 1
                
                if (nextDistance < distanceArray[nextNodeNumber]) {
                    distanceArray[nextNodeNumber] = nextDistance
                    queue.add(Node(nextNodeNumber, nextDistance))
                }
            }
        }
        
        return distanceArray
    }
    
    data class Node(
        val number: Int,
        val distance: Int
    )
}