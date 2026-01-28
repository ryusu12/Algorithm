import java.util.*;

class Solution {
    
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        
        // 열마다 총 석유량 1~land[0].len
        int[] oil = new int[m];
        
        // 한 덩어리 석유 크기 확인하기
        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(n, m, i, j, land, visited, oil);
                }
            }
        }
        
        // 총 석유량 중 최대값 .. 정렬
        Arrays.sort(oil);
    
        return oil[m - 1];
    }
    
    private void bfs(int n, int m, int sx, int sy, int[][] land, boolean[][] visited, int[] oil) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        
        visited[sx][sy] = true;
        int size = 0;
        
        // 어느열에 지나갔는지 확인
        Set<Integer> set = new HashSet<>();
        set.add(sy);
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            size++;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                boolean inRange = nx >= 0 && ny >= 0 && nx < n && ny < m;
                if (inRange && !visited[nx][ny] && land[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    set.add(ny);
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        
        // 지나간 열에 석유크기 갱신
        for (int s : set) {
            oil[s] += size;
        }
    }
}