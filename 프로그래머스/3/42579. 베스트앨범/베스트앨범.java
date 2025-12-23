import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 1. 많이 재생된 장르 -> {장르, 재생횟수}를 담는 Map 저장
        Map<String, Integer> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        // 재생횟수 value 기준 정렬
        List<String> genreValueSort = new ArrayList<>(genreMap.keySet());
        genreValueSort.sort((a, b) -> genreMap.get(b) - genreMap.get(a));


        // 2. 많이 재생된 노래 ->  {장르,[고유번호, 재생횟수]}를 담는 Map 저장
        Map<String, List<int[]>> playMap = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            playMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new int[]{i, plays[i]});
        }
        
        // 3. 앨범에 넣기
        List<Integer> result = new ArrayList<>();
        for (String genre : genreValueSort) {
            List<int[]> songsByGenre = playMap.get(genre);
            // 재생횟수 value 기준 정렬 + 고유 번호가 낮은 노래 순으로 정렬
            songsByGenre.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
            // 곡은 무조건 1개 이상 + 2개 이상이면 2개 넣기
            result.add(songsByGenre.get(0)[0]);
            if (songsByGenre.size() >= 2) {
                result.add(songsByGenre.get(1)[0]);
            }
        }

        // 4. List<Integer>를 int[] 배열로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}