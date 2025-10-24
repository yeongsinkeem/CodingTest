import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public class Genre {
        String type;
        int play;
        Map<Integer, Integer> map = new HashMap<>();
        
        public Genre(String type) {
            this.type = type;
            this.play = 0;
            this.map = new HashMap<>();
        }
        
        public void addSong(int idx, int cnt) {
            // 장르 총 재생 수 누적
            this.play += cnt;
            // <고유 번호, 재생 수> 추가
            this.map.put(idx, cnt);
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        // 1. 장르별로 hashMap 생성
        Map<String, Genre> genreMap = new HashMap<>();
        
        // 2. 장르맵에 장르 정의해서 넣기 -> { classic : classic, 1450, [3:800, 0:500, ..] }
        for(int i = 0; i < genres.length; i++) {
            String genreName = genres[i];
            
            // 장르별 총 재생 수와, 고유 곡들 저장 
            Genre current = genreMap.getOrDefault(genreName, new Genre(genreName));
            current.addSong(i, plays[i]);
            
            genreMap.put(genreName, current);
        }
        
        // 3. 총 재생수 기준으로 genreMap 정렬
        // 장르맵 안의 값을 꺼내야 함 List 형식으로
        // 그래야 정렬 가능하기 때문
        // pop, classic 순서로 정렬됨
        List<Genre> genreList = new ArrayList<>(genreMap.values());
        genreList.sort((g1, g2) -> g2.play - g1.play);
        
        // 4. 각 장르별로 정렬
        List<Integer> answerList = new ArrayList<>();
        for(Genre genre: genreList) {
            // 4-1. <고유번호, 재생수> 리스트 생성 
            List<Map.Entry<Integer, Integer>> songList = new ArrayList<>(genre.map.entrySet());
            
            List<Map.Entry<Integer, Integer>> sortedSongList = songList.stream()
                .sorted((s1, s2) -> {
                    if(s1.getValue().equals(s2.getValue())) return s1.getKey() - s2.getKey();
                    
                    return s2.getValue() - s1.getValue();
                })
                .collect(Collectors.toList());
            
            // 5. 두 개의 장르에 대해 1, 2위 정답에 추가 
            answerList.add(sortedSongList.get(0).getKey());
            
            if (sortedSongList.size() > 1) {
                answerList.add(sortedSongList.get(1).getKey());
            }
        }
        return answerList.stream()
                         .mapToInt(i -> i)
                         .toArray();
    }
}