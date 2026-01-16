import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 거리 저장
        int max = 0;
        int[] visited = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = 1;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            
            for (int i = 0; i < edge.length; i++) {
                // 본인거 와 이어진거 찾기
                if (edge[i][0] == now && visited[edge[i][1]] == 0) {
                    // 거리 저장 및 최대 거리 갱신
                    visited[edge[i][1]] = visited[now] + 1;
                    max = Math.max(max, visited[edge[i][1]]);
                    q.offer(edge[i][1]);
                }
                else if (edge[i][1] == now && visited[edge[i][0]] == 0) {
                    visited[edge[i][0]] = visited[now] + 1;
                    max = Math.max(max, visited[edge[i][0]]);
                    q.offer(edge[i][0]);
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == max) {
                answer++;
            }
        }
        
        return answer;
    }
}