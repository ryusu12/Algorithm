import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    // 동남서북
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] map;
    static boolean[][] visited;
    static int[][] count;

    static List<Integer> left = new ArrayList<>(Arrays.asList(4, 1, 3, 6));
    static List<Integer> down = new ArrayList<>(Arrays.asList(2, 1, 5, 6));

    static int nextCount = 0;
    static long score = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // nm map
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m]; // 이미 사전에 칸 개수 구했는지
        count = new int[n][m]; // 이동횟수 체크

        // 주사위 좌표 : x, y / 현재이동방향(0) : dir
        int x = 0;
        int y = 0;
        int dir = 0;

        // 이동 k 동안 쭉 진행
        while (k > 0) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 갈 수 있는지 확인 -> 칸이 없으면 : 방향 반전하고 진행 (0 <> 2 / 1 <> 3)
            if (!inMap(ny, nx)) {
                dir = (dir + 2) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            // 좌표 이동
            moveDice(dir); // 주사위 상태 변경 : dir에 따라

            // 획득 점수 = 도착칸 * 도착칸의 동서남북으로 쭉 이동할수있는 칸의 개수
            int now = map[ny][nx];
            nextCount = 0;

            // visited true면 그 위치에 이동횟수 점수 그대로 출력
            if (visited[ny][nx]) {
                nextCount = count[ny][nx];
            } else {
                // 방문한 좌표 기록
                List<int[]> xy = new ArrayList<>();
                dfs(ny, nx, now, xy);
                // 이동횟수 기록 : 재사용하기
                for (int[] v : xy) {
                    count[v[0]][v[1]] = nextCount;
                }
            }

            score += now * nextCount;

            // 방향 변환 : dir 동남서북
            int dice = left.get(3); // 아랫면
            if (dice > now) dir = (dir + 1) % 4;
            if (dice < now) dir = (dir + 3) % 4;

            x = nx;
            y = ny;

            k--; // 이동횟수 차감
        }
        System.out.println(score);
    }

    // 동서남북 다 방문 : dfs 해서, visited 체크(map크기 bool), 이동횟수 체크(map크기 int)
    private static void dfs(int y, int x, int now, List<int[]> xy) {
        visited[y][x] = true;
        nextCount++;
        xy.add(new int[] {y,x});

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (inMap(ny, nx) && !visited[ny][nx] && map[ny][nx] == now) {
                dfs(ny, nx, now, xy);
            }
        }
    }

    private static void moveDice(int dir) {
        // 동서/남북 0,3 위치 맞춰주기
        if (dir == 0) {
            // 동 <<
            left.add(0, left.remove(3));
            down.set(1, left.get(1));
            down.set(3, left.get(3));
        } else if (dir == 1) {
            // 남 <<
            down.add(0, down.remove(3));
            left.set(1, down.get(1));
            left.set(3, down.get(3));
        } else if (dir == 2) {
            // 서 >>
            left.add(left.remove(0));
            down.set(1, left.get(1));
            down.set(3, left.get(3));
        } else {
            // 북 >>
            down.add(down.remove(0));
            left.set(1, down.get(1));
            left.set(3, down.get(3));
        }
    }

    private static boolean inMap(int y, int x) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
