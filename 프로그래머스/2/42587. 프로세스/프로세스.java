import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> priorityQue = new LinkedList<>();
        Queue<Integer> idxQue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            priorityQue.add(priorities[i]);
            idxQue.add(i);
        }

        int answer = 0;

        while (!priorityQue.isEmpty()) {
            // 1번
            int priority = priorityQue.poll();
            int idx = idxQue.poll();
            // 2번
            boolean flag = true;
            for (int p : priorityQue) {
                if (priority < p) {
                    flag = false;
                    break;
                }
            }
            // 3번
            if (flag) {
                answer++;
                if (idx == location) return answer;
            } else {
                priorityQue.add(priority);
                idxQue.add(idx);
            }
        }
        return answer;
    }

}