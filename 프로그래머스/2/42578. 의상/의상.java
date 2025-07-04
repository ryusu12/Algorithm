import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        // 각 종류 입는 경우 구하기
        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
        // 조합 : 각 종류 곱하기 - 안입는 경우 +1
        for (Integer value : map.values()) {
            answer *= value + 1;
        }
        // 아무것도 안입는 경우 빼기 : -1
        return answer - 1;
    }
}