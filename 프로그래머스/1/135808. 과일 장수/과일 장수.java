import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        List<Integer> boxs = new ArrayList<>();
        for (int s : score) {
            if (s <= k) boxs.add(s);
        }
        boxs.sort(Collections.reverseOrder());
        
        for (int i = m - 1; i < boxs.size(); i += m) {
            answer += boxs.get(i) * m;
        }
        return answer;
    }
}