import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        // 각 횟수 측정
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        // value 기준 sort
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((a, b) -> map.get(b).compareTo(map.get(a)));
        // 횟수 큰거부터 확인
        for (Integer key : keySet) {
            answer++;
            k -= map.get(key);
            if (k <= 0) break;
        }
        return answer;
    }
}