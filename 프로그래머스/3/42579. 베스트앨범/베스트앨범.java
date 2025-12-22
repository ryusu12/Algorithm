import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> result = new ArrayList<>();

        // 1. 많이 재생된 장르 -> {장르, 재생횟수}를 담는 Map 저장
        Map<String, Integer> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        // 재생횟수 value 기준 정렬
        List<String> genreValueSort = new ArrayList<>(genreMap.keySet());
        genreValueSort.sort((a, b) -> genreMap.get(b) - genreMap.get(a));


        // 2. 많이 재생된 노래 -> {고유번호, 재생횟수}를 담는 Map 저장
        Map<Integer, Integer> playMap = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            playMap.put(i, plays[i]);
        }
        List<Integer> playValueSort = new ArrayList<>(playMap.keySet());
        // 재생횟수 value 기준 정렬 + 고유 번호가 낮은 노래 순으로 정렬
        playValueSort.sort((a, b) -> {
            if (playMap.get(b).equals(playMap.get(a))) {
                return a - b;
            }
            return playMap.get(b) - playMap.get(a);
        });

        // 3. 장르별 2개씩 -> {장르, 수록횟수} Map 선언
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < genreValueSort.size(); i++) {
            countMap.put(genreValueSort.get(i), 0);
        }

        // 4. 앨범에 넣기
        for (String genre : genreValueSort) {
            for (int i = 0; i < playValueSort.size(); i++) {
                // 장르가 일치하는지? +  2개씩 안들어갔는지?
                if (genres[playValueSort.get(i)].equals(genre) && countMap.get(genre) < 2) {
                    // 수록횟수 갱신 + 앨범에 넣기
                    countMap.put(genre, countMap.getOrDefault(genre, 0) + 1);
                    result.add(playValueSort.get(i));
                }
            }
        }

        // 5. List<Integer>를 int[] 배열로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}