import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        boolean[] done = new boolean[progresses.length];
        List<Integer> finish = new ArrayList<>();
        int start = 0;

        // done이 모두 true일 때 까지
        while(start < progresses.length) {
            // progresses 진행도 갱신
            int endIdx = -1;
            for (int i = start; i < progresses.length; i++) {
                progresses[i] += speeds[i];
                if (progresses[i] >= 100) {
                    done[i] = true;
                    endIdx = i;
                }
            }

            // done[0~i] 가 true 이면
            boolean flag = false;
            for (int i = start; i <= endIdx; i++) {
                if (!done[i]) {
                    endIdx = i - 1;
                    break;
                }
                flag = true;
            }
            if (flag) {
                finish.add(endIdx - start + 1);
                start = endIdx + 1;
            }
        }
        // 완료된 기능 개수 파악 후 저장
        // answer[idx++]
        int[] answer = new int[finish.size()];
        for (int i = 0; i < finish.size(); i++) answer[i] = finish.get(i);
        return answer;
    }
}