
class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val clothesMap: MutableMap<String, MutableList<String>> = HashMap()

        clothes
            .forEach { clothe ->
                val clothesMapValue = clothesMap
                    .getOrDefault(clothe[1], mutableListOf())
                    .apply {
                        this.add(clothe[0])
                    }

                clothesMap[clothe[1]] = clothesMapValue
            }

        return clothesMap
            .values
            .map {
                it.size + 1
            }
            .reduce { acc, i -> 
                acc * i
            }
            .let {
                it - 1
            }
    }
}