import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 각 작업일 저장
        Queue<Integer> que = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int count = 0;
            if ((100 - progresses[i]) % speeds[i] > 0) {
                count = (100 - progresses[i]) / speeds[i] + 1;
            } else {
                count = (100 - progresses[i]) / speeds[i];
            }
            que.offer(count);
        }
        
        // 이전에 나간 값이 더 크면 당일배포수++
        List<Integer> list = new ArrayList<>();
        int before = que.poll();
        int out = 1;
        while (!que.isEmpty()) {
            int now = que.poll();
            if (before < now) {
                list.add(out);
                out = 1;
                before = now;
            } else {
                out++;
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