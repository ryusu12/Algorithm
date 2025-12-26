import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        // 정렬 -> 힙
        Queue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) heap.offer(scoville[i]);
        
        while (heap.size() > 1) {
            // 맨앞값 >= K ? 끝내기
            if (heap.peek() >= K) break;
            // 앞에 두개 계산 -> 다시 넣기 + answer++
            heap.offer(heap.poll() + heap.poll() * 2);
            answer++;
        }
        if (heap.poll() < K) return -1;
        return answer;
    }
}