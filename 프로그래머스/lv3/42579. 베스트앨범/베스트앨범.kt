class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val genreAndMusicMap: MutableMap<String, MutableList<Music>> = HashMap()
        
        for (i in genres.indices) {
            val music = Music(id = i, genre = genres[i], playCount = plays[i])
            
            genreAndMusicMap.getOrPut(genres[i]) { mutableListOf() }.add(music)
        }
        
        val sortedGenres = genreAndMusicMap
            .entries
            .sortedByDescending { 
                it.value.sumBy { music -> music.playCount }
            }
            .map {
                it.key
            }
        
        val answer: MutableList<Int> = mutableListOf()
        
        for (i in sortedGenres.indices) {
            val topMusics = genreAndMusicMap[sortedGenres[i]]
                    ?.sortedWith(compareBy({ -it.playCount }, { it.id }))
                    ?.take(2) ?: emptyList()
            
            for (j in topMusics.indices) {
                answer.add(topMusics[j].id)
            }
        }
        
        return answer.toIntArray()
    }
}

data class Music(
    val id: Int,
    val genre: String,
    val playCount: Int
)