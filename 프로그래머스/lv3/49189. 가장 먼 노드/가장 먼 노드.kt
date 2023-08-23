import java.util.*

class Solution {
    companion object {
        private const val START_NODE = 1
    }
    
    fun solution(n: Int, edge: Array<IntArray>): Int {
        val edges: MutableList<MutableList<Int>> = mutableListOf()
        
        for (i in 0 .. n) {
            edges.add(mutableListOf())
        }
        
        for (i in edge.indices) {
            edges.get(edge[i][0]).add(edge[i][1])
            edges.get(edge[i][1]).add(edge[i][0])
        }
        
        val distanceArray: IntArray = djkstra(edges, START_NODE, n)
        
        var maxDistance: Int = 0
        
        for (i in distanceArray.indices) {
            if (distanceArray[i] == Int.MAX_VALUE) continue
            
            if (distanceArray[i] > maxDistance) {
                maxDistance = distanceArray[i]
            }
        }
        
        val maxDistanceCount = distanceArray.count { it == maxDistance }
        
        return maxDistanceCount
    }
    
    fun djkstra(
        edges: MutableList<MutableList<Int>>,
        startNode: Int,
        nodeCount: Int
    ): IntArray {
        val priorityQueue: PriorityQueue<Node> = PriorityQueue() {
                a, b -> a.distance - b.distance
        }

        val distance: IntArray = IntArray(nodeCount + 1)

        for (i in distance.indices) {
            distance[i] = Int.MAX_VALUE
        }

        priorityQueue.add(Node(startNode, 0))
        distance[startNode] = 0

        while (!priorityQueue.isEmpty()) {
            val currentNode: Node = priorityQueue.poll()

            if (currentNode.distance > distance[currentNode.number]) {
                continue
            }

            val nextNodes = edges.get(currentNode.number)

            for (i in nextNodes.indices) {
                val nextNode = edges.get(currentNode.number)[i]

                if (currentNode.distance + 1 < distance[nextNode]) {
                    priorityQueue.add(Node(nextNode, currentNode.distance + 1))
                    distance[nextNode] = currentNode.distance + 1
                }
            }
        }

        return distance
    }
}

data class Node(
    val number: Int,
    val distance: Int = 1
)