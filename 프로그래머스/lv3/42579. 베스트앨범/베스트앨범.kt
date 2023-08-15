class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        // 속한 노래가 많이 재생된 장르 우선
        // 장르 내에서 많이 재생된 노래 우선
        // 장래 내에서 재생 횟수가 같은 경우 고유 번호가 낮은 노래 먼저 수록
        
        // genres[i] == 고유 번호 [i]인 노래의 장르
        // plays[i] == 고유 번호가 [i]인 노래의 재생 횟수
        
        val musicPlayCountMap: MutableMap<String, Int> = HashMap()
        val genreAndMusicMap: MutableMap<String, MutableList<Music>> = HashMap()

        for (i in genres.indices) {
            val n = musicPlayCountMap
                .getOrDefault(genres[i], 0)
                .let { it + plays[i] }

            val musicList = genreAndMusicMap
                .getOrDefault(genres[i], mutableListOf())
                .let {
                    it.add(Music(id = i, genre = genres[i], playCount = plays[i]))
                    it
                }

            musicPlayCountMap[genres[i]] = n
            genreAndMusicMap[genres[i]] = musicList
        }
        
        val sortedGenres: List<String> = musicPlayCountMap
            .entries
            .sortedByDescending { it.value }
            .map { it.key }
            
        genreAndMusicMap
            .forEach { map ->
                map.value.sortWith(
                    compareBy({ -it.playCount }, { it.id })
                )
            }
        
        val answer: MutableList<Int> = mutableListOf()
        
        for (i in sortedGenres.indices) {
            val musics = genreAndMusicMap[sortedGenres[i]]
            
            for (j in 0 .. 1) {
                if (musics != null && musics.size > j) {
                    answer.add(musics[j].id)
                }
            }
        }
            
        return answer.toIntArray()
    }
}

class Music(
    val id: Int,
    val genre: String,
    val playCount: Int,
)