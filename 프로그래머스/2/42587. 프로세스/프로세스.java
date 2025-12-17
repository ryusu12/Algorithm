import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        for (int p : priorities) {
            que.offer(p);
        }
        
        // 최대값을 구하는 배열 -> pop 빠질때마다 idx--
        Arrays.sort(priorities);
        int idx = priorities.length - 1;
        
        // 큐가 비어있을때까지 순환
        while (!que.isEmpty()) {
            // 맨앞 >= 큐의 최대값 ? pop + answer++ : pop + push
            // 이동할때마다 location 갱신
            if (que.peek() >= priorities[idx]) {
                if (location == 0) {
                    return answer + 1;
                } else {
                    location--;
                }
                que.poll();
                answer++;
                idx--;
            } else {
                if (location == 0) {
                    location = que.size() - 1;
                } else {
                    location--;
                }
                que.offer(que.poll());
            }
        }
        return answer;
    }
}