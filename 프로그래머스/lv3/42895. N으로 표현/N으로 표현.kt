class Solution {
    fun solution(N: Int, number: Int): Int {
        val setList: MutableList<MutableSet<Int>> = mutableListOf()
        
        for (i in 0 .. 7) {
            setList.add(mutableSetOf())
        }
        
        for (i in 0 until setList.size) {
            var value = 0
            
            for (j in 0 .. i) {
                value += (Math.pow(10.0, j.toDouble()) * N).toInt()
            }
            
            setList.get(i).add(value)
        }
        
        for (i in 1 .. 7) {
            val currentSet = setList.get(i)
            val tempSet: MutableSet<Int> = mutableSetOf()
            
            for (j in 0 until i) {
                val prevSet = setList.get(j)
                val postSet = setList.get(i-j-1)
                
                for (p1 in prevSet) {
                    for (p2 in postSet) {
                        
                        val n1 = p1 + p2
                        val n2 = p1 * p2
                        val n3 = p1 - p2
                        
                        tempSet.add(n1)
                        tempSet.add(n2)
                        tempSet.add(n3)
                        
                        if (p1 != 0 && p2 != 0) {
                            val n4 = p1/p2
                            val n5 = p2/p1
                            
                            tempSet.add(n4)
                            tempSet.add(n5)
                        }
                    }
                }
            }
            
            currentSet.addAll(tempSet)
        }
        
        for (i in setList.indices) {
            
            if (setList.get(i).contains(number)) {
                return i + 1
            }
        }
        
        return -1
    }
}