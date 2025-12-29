import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        // 최대값 정렬 힙 + 최소값 정렬 힙
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b.compareTo(a));
        Queue<Integer> minHeap = new PriorityQueue<>((a,b) -> a.compareTo(b));
        
        for (String oper : operations) {
            String[] operArr = oper.split(" ");
            // | 가 있으면 두 큐에 모두 삽입
            if (operArr[0].equals("I")) {
                int num = Integer.parseInt(operArr[1]);
                maxHeap.offer(num);
                minHeap.offer(num);
            }
            // "D 1" 이면 최대값힙 poll / "D -1" 이면 최소값힙 poll - 다른 한쪽도 삭제해서 동기화
            else if (operArr[0].equals("D")) {
                int num = Integer.parseInt(operArr[1]);
                if (num < 0) {
                    maxHeap.remove(minHeap.poll());
                } else {
                    minHeap.remove(maxHeap.poll());
                }
            }
        }
       
        // 큐가 비어있으면 [0,0] - 하나라도 비어있으면 둘다 비어있음
        if (maxHeap.isEmpty()) {
            return new int[]{0,0};
        }
        // 비어있지 않으면 [최댓값, 최솟값]
        return new int[] {maxHeap.peek(), minHeap.peek()};
    }
}