import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        Queue<Integer> honor = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            honor.add(score[i]);
            if (honor.size() > k) {
                honor.poll();
            }
            answer[i] = honor.peek();
        }
        return answer;
    }
}