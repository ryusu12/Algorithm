import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 이동 최단 거리 : BFS
        // 모서리를 걸쳐서 지나가기 : 칸으로 만들기위해 공간 2배로 생성 -> 101 크기
        int[][] map = new int[101][101];
        
        int[][] visited = new int[101][101];
        Queue<int[]> que = new LinkedList<>();
        
        visited[characterX *2][characterY*2] = 0;
        que.offer(new int[]{characterX *2, characterY*2});
        
        // 모서리 1 : 사각형 모두 1로하고 내부를 0으로 지움
        for (int[] r : rectangle) {
            for (int i = r[0] *2; i <= r[2] *2; i++) {
                for (int j = r[1] *2; j <= r[3] *2; j++) {
                    map[i][j] = 1;
                }
            }
        }
        for (int[] r : rectangle) {
            for (int i = r[0] *2 +1; i < r[2] *2; i++) {
                for (int j = r[1] *2 +1; j < r[3] *2; j++) {
                    map[i][j] = 0;
                }
            }
        }
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while (!que.isEmpty()) {
            int[] now = que.poll();
            int x = now[0];
            int y = now[1];
            
            // 목적지 도착
            if (x == itemX *2 && y == itemY *2) {
                return visited[x][y] / 2;
            }
            
            // 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                boolean inRange = nx >= 0 && ny >= 0 && nx <= 100 && ny <= 100;
                // 그래프안, 안간곳, 이동가능 1
                if (inRange && visited[nx][ny] == 0 && map[nx][ny] == 1) {
                    visited[nx][ny] = visited[x][y] + 1;
                    que.offer(new int[]{nx, ny});
                }
            }
        }
        
        return 0;
    }
}