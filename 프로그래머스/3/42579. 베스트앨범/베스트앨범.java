import java.util.*;

class Solution {
    class Song {
        int id;
        int play;
        
        public Song (int id, int play) {
            this.id = id;
            this.play = play;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answerLst = new ArrayList<>();
        
        // 1. 장르 hashMap 생성 
        // ex. classic : 1450, pop : 3100
        Map<String, Integer> genreMap = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 2. 노래 hashMap 생성
        // ex. { classic : [0, 500], [2, 800], .. }
        Map<String, List<Song>> songMap = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {

            songMap.computeIfAbsent(genres[i], k -> new ArrayList<>())
                   .add(new Song(i, plays[i]));
        }
        
        // 3. genreMap 정렬
        List<String> sortedGenres = new ArrayList<>(genreMap.keySet());
        sortedGenres.sort( (a, b) -> genreMap.get(b) - genreMap.get(a));
        
        // 4. 장르 내 노래들 정렬
        for(String g : sortedGenres) {
            List<Song> songs = songMap.get(g);
            songs.sort( (a, b) -> {
                // 재생수 같으면 idx
                if( a.play == b.play ) return a.id - b.id;
                return b.play - a.play;
            });
            
            // 최대 2개씩만 출력 
            // 각 장르에 해당하는 노래들
            for(int i = 0; i < Math.min(songs.size(), 2); i++) {
                answerLst.add(songs.get(i).id);
            }
        }
        
        int[] answer = new int[answerLst.size()];
        for(int j = 0; j < answer.length; j++) {
            answer[j] = answerLst.get(j);
        }
        
        return answer;
    }
}