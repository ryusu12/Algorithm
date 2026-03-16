import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int out = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[] ddx = {-1, -1, 0, 0, -2, 0, 0, 1, 1, -1};
    static int[] ddy = {-1, 1, -2, 2, 0, -1, 1, -1, 1, 0};

    static int[] percent = {10, 10, 2, 2, 5, 7, 7, 1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 시작지점
        int nx = n / 2;
        int ny = n / 2;

        int move = 0;
        int len = 1;
        while(true) {
            // 1,1 -> 2,2 -> 3,3
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < len; j++) {
                    nx += dx[move];
                    ny += dy[move];
                    spreadMap(nx, ny, move);
                    if (nx == 0 && ny == 0) {
                        System.out.println(out);
                        return;
                    }
                }
                move = (move + 1) % 4;
            }
            len++;
        }
    }

    private static void spreadMap(int x, int y, int moveIdx) {
        int sum = 0;
        for (int i = 0; i < percent.length; i++) {
            // 방향 조정
            int nx = x + rotate(ddx[i], ddy[i], moveIdx, true);
            int ny = y + rotate(ddx[i], ddy[i], moveIdx, false);

            int spread = (map[y][x] * percent[i]) / 100;
            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                // 맵 안이면 모래 이동하기
                map[ny][nx] += spread;
            } else {
                // 모래 밖으로 나감
                out += spread;
            }
            sum += spread;
        }

        int ax = x + rotate(ddx[9], ddy[9], moveIdx, true);
        int ay = y + rotate(ddx[9], ddy[9], moveIdx, false);

        int a = map[y][x] - sum;
        if (ax >= 0 && ax < n && ay >= 0 && ay < n) {
            map[ax][ay] += a;
        } else {
            out += a;
        }
        map[y][x] = 0;
    }

    static int rotate(int x, int y, int move, boolean isX) {
        // 좌 하 우 상
        if (move == 0) return isX ? x : y;
        if (move == 1) return isX ? y : -x;
        if (move == 2) return isX ? -x : -y;
        if (move == 3) return isX ? -y : x;
        return 0;
    }
}


