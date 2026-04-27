import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static List<int[]> bio;
    static int answer = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m]; // 1 벽 / 2 바이러스
        bio = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    bio.add(new int[]{i, j});
                }
            }
        }

        // 벽 세우기
        dfs(0);

        // 0의 최대값
        System.out.println(answer);
    }

    private static void dfs(int count) {
        if (count == 3) {
            // 바이러스 상하좌우
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        int[][] newMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            newMap[i] = map[i].clone();
        }
        for (int[] b : bio) {
            q.offer(b);
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[1];
            int y = now[0];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (inMap(nx, ny) && newMap[ny][nx] == 0) {
                    newMap[ny][nx] = 2;
                    q.offer(new int[] {ny, nx});
                }

            }
        }

        // 0의 최대값
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (newMap[i][j] == 0) {
                    count++;
                }
            }
        }
        answer = Math.max(answer, count);
    }

    private static boolean inMap(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}