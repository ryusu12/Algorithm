import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        
        for (int i = 0; i < arr.length; i++) {
            // 이전 값이랑 다르면 넣기
            if (i > 0 && arr[i - 1] != arr[i]) {
                list.add(arr[i]);
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