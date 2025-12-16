import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 각 작업일 배열
        int[] last = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] > 0) {
                last[i] = (100 - progresses[i]) / speeds[i] + 1;
            } else {
                last[i] = (100 - progresses[i]) / speeds[i];
            }
        }
        
        // 이전에 나간 값이 더 크면 당일배포수++
        List<Integer> list = new ArrayList<>();
        int before = last[0];
        int out = 1;
        for (int i = 1; i < last.length; i++) {
            if (before >= last[i]) {
                out++;
            }
            else {
                list.add(out);
                out = 1;
                before = last[i];
            }
        }
        list.add(out);
        
        // List<Integer> -> int[]
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}