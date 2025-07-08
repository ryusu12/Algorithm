import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> que = new LinkedList<>();
        List<Integer> finish = new ArrayList<>();
        // 몇일 걸리는지 확인
        for (int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            que.add(day);
        }
        while (!que.isEmpty()) {
            int first = que.poll();
            int count = 1;
            while (!que.isEmpty() && first >= que.element()) {
                que.remove();
                count++;
            }
            finish.add(count);
        }
        int[] answer = new int[finish.size()];
        for (int i = 0; i < finish.size(); i++) answer[i] = finish.get(i);
        return answer;
    }
}