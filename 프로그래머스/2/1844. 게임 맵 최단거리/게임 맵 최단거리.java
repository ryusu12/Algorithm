import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = Integer.MAX_VALUE;
        int rows = maps.length;
        int cols = maps[0].length;
        // 이동방향
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        // 지금까지 이동한 거리 저장
        int[][] visited = new int[rows][cols];
        visited[0][0] = 1;
        
        // 앞으로 가야할 공간 확인
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, 0});
        
        // while 모두 탐색할때까지
        while (!que.isEmpty()) {
            int[] now = que.poll();
            
            // 최종목적지까지 가면 현재 거리 반환
            if (now[0] == rows - 1 && now[1] == cols - 1) {
                return visited[now[0]][now[1]];
            }

            // 갈수있는 방향 탐색
            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                // 맵 범위 안, 방문안했고, 1이면 ? 이동 :거리 갱신, 다음 갈 공간 큐에 저장
                boolean inMap = x >= 0 && x < rows && y >= 0 && y < cols;
                if (inMap && visited[x][y] == 0 && maps[x][y] == 1) {
                    visited[x][y] = visited[now[0]][now[1]] + 1;
                    que.offer(new int[]{x, y});
                }
            }
        }
        // 도착 불가
        return -1;
    }
}