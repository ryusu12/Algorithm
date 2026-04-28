import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static int clean;

    // 북동남서
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        run(x, y, d);
        System.out.println(clean);
    }

    private static void run(int x, int y, int d) {
        while (true) {
            // 현재위치 청소 안됨 ? 청소
            if (map[y][x] == 0) {
                map[y][x] = 2;
                clean++;
            }

            boolean flag = false;
            // 반시계방향 회전 하면서, 0 찾음
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nx = x + dx[d];
                int ny = y + dy[d];
                // 한칸 전진 후 1번으로
                if (inMap(nx, ny) && map[ny][nx] == 0) {
                    x = nx;
                    y = ny;
                    flag = true;
                    break;
                }
            }

            // 상하좌우 청소됨 ? 바라본 방향으로 후진(후진못하면 멈춤). 1번으로돌아감
            if (!flag) {
                int nd = (d + 2) % 4; // 후진 방향
                int nx = x + dx[nd];
                int ny = y + dy[nd];
                if (inMap(nx, ny) && map[ny][nx] != 1) {
                    x = nx;
                    y = ny;
                } else {
                    return;
                }
            }
        }
    }

    private static boolean inMap(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}