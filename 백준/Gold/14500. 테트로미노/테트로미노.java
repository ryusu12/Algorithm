import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int result = 0;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(j, i, 1, map[i][j]);
                visited[i][j] = false;
            }
        }

        // 맞으면 좌표의 합을 리턴
        System.out.println(result);
    }

    private static void dfs(int x, int y, int count, int sum) {
        if (count == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!inMap(nx, ny) || visited[ny][nx]) continue;

            // ㅜ형 탐색 현재 위치에서 다시 탐색
            if (count == 2) {
                visited[ny][nx] = true;
                dfs(x, y, count + 1, sum + map[ny][nx]);
                visited[ny][nx] = false;
            }

            visited[ny][nx] = true;
            dfs(nx, ny, count + 1, sum + map[ny][nx]);
            visited[ny][nx] = false;
        }
    }

    private static boolean inMap(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
