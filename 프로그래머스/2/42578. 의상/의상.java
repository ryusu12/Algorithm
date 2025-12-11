import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 종류마다 : 1, 2, 선택안함 - n+1
        // map <종류, 수>
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        int answer = 1;
        for (Integer value : map.values()) {
            answer *= (value + 1);
        }
        // 최소 한 개의 의상은 입습니다.
        return answer - 1;
    }
}