import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int idx = -1;
        
        for (int i = 0; i < arr.length; i++) {
            // 직전에 넣은 값이랑 다르면 넣기
            if (idx == -1 || list.get(idx) != arr[i]) {
                list.add(arr[i]);
                idx++;
            }
        }
        
        // List<Integer> -> int[]
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}