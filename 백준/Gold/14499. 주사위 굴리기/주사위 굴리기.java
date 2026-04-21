import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;

    // 가장 처음 주사위에는 모든면이 0
    static List<Integer> ud = new ArrayList<>(Arrays.asList(0, 0, 0, 0));
    static List<Integer> lr = new ArrayList<>(Arrays.asList(0, 0, 0, 0));

    // 동서북남
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int dir = Integer.parseInt(st.nextToken()) - 1;

            // 주사위 이동
            // 주사위 좌표 이동
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 이동범위 벗어나면 명령 무시 + 출력안함
            if (!inMap(nx, ny)) continue;

            // 주사위 상태 변경
            changeDice(dir);

            // 이동한 칸이 0 ? 주사위 바닥면이 칸에 복사됨
            if (map[ny][nx] == 0) {
                map[ny][nx] = lr.get(3);
            } else {
                // 아니면  칸이 주사위 바닥면에 복사됨 + 칸은 0으로 됨
                lr.set(3, map[ny][nx]);
                ud.set(3, map[ny][nx]);
                map[ny][nx] = 0;
            }
            // 주사위 윗면 출력
            sb.append(lr.get(1)).append('\n');

            x = nx;
            y = ny;
        }
        System.out.println(sb);
    }

    private static void changeDice(int dir) {
        // 윗면 1 / 바닥면 3 - 북 : ud<- 남 ud-> / 동 lr-> 서lr<-

        // 동서북남
        if (dir == 0) {
            lr.add(0, lr.remove(3));
            ud.set(1, lr.get(1));
            ud.set(3, lr.get(3));
        } else if (dir == 1) {
            lr.add(lr.remove(0));
            ud.set(1, lr.get(1));
            ud.set(3, lr.get(3));
        } else if (dir == 2) {
            ud.add(ud.remove(0));
            lr.set(1, ud.get(1));
            lr.set(3, ud.get(3));
        } else {
            ud.add(0, ud.remove(3));
            lr.set(1, ud.get(1));
            lr.set(3, ud.get(3));
        }
    }

    private static boolean inMap(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}