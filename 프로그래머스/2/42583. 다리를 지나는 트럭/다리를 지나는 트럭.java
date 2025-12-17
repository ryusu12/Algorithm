import java.util.*;
/**
정해진 순으로 건너기
모든 트럭이 건너려면 최소 몇 초가 걸리는지
bridge_length : 동시에 몇개
1초당 1 length
*/
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        
        // 대기 큐 : truck_weights -> idx 이동으로 판별
        int idx = 0;
        // 진입 큐 (inQ) : 크기 bridge_length {트럭무게, 진행도}
        Queue<int[]> inQ = new LinkedList<>();
        
        // 진입큐의 남은 크기가 : 대기 큐에서 들어올수 잇으면 & 대기큐가 비어있지 않을때 ? 진입큐 add
        if (idx < truck_weights.length && weight >= truck_weights[idx]) {
            inQ.offer(new int[]{truck_weights[idx], 0});
            weight -= truck_weights[idx];
            idx++;
        }
        // 1초 경과 -> while문 : 모든 큐가 비어있을때까지
        while(!inQ.isEmpty() || idx < truck_weights.length) {
            //  : 진입큐 모두 진행도+1
            for (int[] q : inQ) {
                q[1]++;
            }
            //  : 진입큐 검사 - 진행도==bridge_length 이면 ? 진입큐 pop
            int[] peek = inQ.peek();
            if (peek[1] == bridge_length) {
                weight += peek[0];
                inQ.poll();
            }
            
            //  : 진입큐의 남은 크기가 : 대기 큐에서 들어올수 잇으면 & 대기큐가 비어있지 않을때 ? 진입큐 add
            if (idx < truck_weights.length && weight >= truck_weights[idx]) {
                inQ.offer(new int[]{truck_weights[idx], 0});
                weight -= truck_weights[idx];
                idx++;
            }
            //  : 시간(time)+1
            time++;
        }
        return time + 1;
    }
}