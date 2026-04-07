import java.io.*;
import java.util.*;

public class Main {

    static int N, Q, N2;
    static int[][] map;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        N2 = (int) Math.pow(2, N);

        map = new int[N2][N2];
        for (int i = 0; i < N2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N2; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int L = Integer.parseInt(st.nextToken());
            splitMap(L);
            melt();
        }

        // 정답
        countIce();
    }

    private static void countIce() {
        int sum = 0;
        int max = 0;
        boolean[][] visited = new boolean[N2][N2];

        // 남아있는 얼음들 합
        for (int y = 0; y < N2; y++) {
            for (int x = 0; x < N2; x++) {
                sum += map[y][x];

                // 가장 큰 얼음 덩어리 크기
                if (map[y][x] > 0 && !visited[y][x]) {
                    max = Math.max(max, bfs(y, x, visited));
                }
            }
        }

        System.out.println(sum);
        System.out.println(max);
    }

    private static int bfs(int y, int x, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if (inMap(ny, nx) && !visited[ny][nx] && map[ny][nx] > 0) {
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                    count++;
                }
            }
        }
        return count;
    }


    private static void melt() {
        List<int[]> meltIce = new ArrayList<>();

        // 상하좌우 얼음이 3개 이상 없으면 : 얼음양 -1
        for (int y = 0; y < N2; y++) {
            for (int x = 0; x < N2; x++) {
                // 현재 없는거 패스
                if (map[y][x] <= 0) continue;

                // 상하좌우에 얼음이 몇개 있는지
                int count = 0;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (inMap(ny, nx) && map[ny][nx] > 0) {
                        count++;
                    }
                }

                if (count < 3) meltIce.add(new int[]{y, x});
            }
        }

        // 얼음 녹이기
        for (int[] m : meltIce) {
            map[m[0]][m[1]]--;
        }
    }

    private static boolean inMap(int y, int x) {
        return x >= 0 && y >= 0 && x < N2 && y < N2;
    }

    private static void splitMap(int L) {
        int L2 = (int) Math.pow(2, L);

        // 격자 나누기 2^L
        for (int i = 0; i < N2; i += L2) {
            for (int j = 0; j < N2; j += L2) {
                round(i, j, L2);
            }
        }
    }

    private static void round(int sy, int sx, int L2) {
        int[][] copyMap = new int[L2][L2];

        // 격자들 회전시키기 : 시계방향 90도
        // [y][x] -> [x][L2-y-1]
        for (int y = 0; y < L2; y++) {
            for (int x = 0; x < L2; x++) {
                copyMap[x][L2 - y - 1] = map[sy + y][sx + x];
            }
        }

        // 적용하기
        for (int y = 0; y < L2; y++) {
            for (int x = 0; x < L2; x++) {
                map[sy + y][sx + x] = copyMap[y][x];
            }
        }
    }
}
