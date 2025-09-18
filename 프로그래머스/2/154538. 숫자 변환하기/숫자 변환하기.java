import java.util.*;

class Solution {
    
    public int solution(int x, int y, int n) {
        // x == y 이면 0
        if (x == y) {
            return 0;
        }
        // bfs를 위한 큐 LinkedList
        Queue<Integer> que = new LinkedList<>();
        que.offer(x);
        
        // 방문기록 int[]
        int[] visited = new int[y + 1];
        visited[x] = 0;
        
        // 큐가 빌 때까지
        while(!que.isEmpty()) {
            int now = que.poll();
            // y에 도달하면 반환
            if (y == now) {
                return visited[now];
            }
            
            int[] nextList = {now + n, now * 2, now * 3};
            
            // y를 초과하지 않고, 아직 미방문하면 추가
            for (int next : nextList) {
                if (next <= y && visited[next] == 0) {
                    que.offer(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }
        // 다 못비우면 -1
        return -1;
    }
}