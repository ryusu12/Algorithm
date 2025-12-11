import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int len = genres.length;
        List<Integer> result = new ArrayList<>();

        // 1. 많이 재생된 장르
        // genreMap = map<genres, 총 재생횟수> -> value 기준 정렬
        Map<String, Integer> genreMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<String> genreByPlay = new ArrayList<>(genreMap.keySet());
        genreByPlay.sort((a, b) -> genreMap.get(b) - genreMap.get(a));


        // 2. 많이 재생된 노래
        // playMap = map<i, plays> -> value(plays) 기준 정렬
        Map<Integer, Integer> playMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            playMap.put(i, plays[i]);
        }
        List<Integer> playKeySet = new ArrayList<>(playMap.keySet());
        // 3.고유 번호가 낮은 노래
        playKeySet.sort((a, b) -> {
            if (playMap.get(b).equals(playMap.get(a))) {
                return a - b;
            }
            return playMap.get(b) - playMap.get(a);
        });

        // 0. 장르별 2개씩
        // countMap = map<genres, 수록횟수>
        List<String> genreKeySet = new ArrayList<>(genreMap.keySet());
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < genreKeySet.size(); i++) {
            countMap.put(genreKeySet.get(i), 0);
        }

        // for genreMap.key
        for (String genre : genreByPlay) {
            for (int i = 0; i < playKeySet.size(); i++) {
                if (genres[playKeySet.get(i)].equals(genre) && countMap.get(genre) < 2) {
                    countMap.put(genre, countMap.getOrDefault(genre, 0) + 1);
                    result.add(playKeySet.get(i));
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