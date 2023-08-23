class Solution {
    fun solution(n: Int, results: Array<IntArray>): Int {
        val INF = Int.MAX_VALUE
        
        // 그래프 초기화 (노드간 거리는 INF, 자기 자신은 0)
        val graph = Array(n + 1) { IntArray(n + 1) { if (it == 0) 0 else INF } }
        
        // 주어진 edges 정보로 그래프에 경로 설정
        for (result in results) {
            graph[result[0]][result[1]] = 1
        }
        
        floydWarshall(n, graph)
        
        return (1..n).count { node ->
            val count = (1..n).count { other ->
                graph[node][other] != INF || graph[other][node] != INF
            }
            count == n - 1
        }
    }
    
    fun floydWarshall(nodeCount: Int, graph: Array<IntArray>) {
        for (k in 1..nodeCount) {
            for (i in 1..nodeCount) {
                for (j in 1..nodeCount) {
                    if (graph[i][k] != Int.MAX_VALUE && graph[k][j] != Int.MAX_VALUE) {
                        graph[i][j] = minOf(graph[i][j], graph[i][k] + graph[k][j])
                    }
                }
            }
        }
    }
}