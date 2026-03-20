import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[4][4]; // map -> 물고기번호만
        int[][] fish = new int[17][3]; // 인덱스= 물고기번호 [y, x, 방향] fish

        // 물고기 : 번호(1~16 유일), 방향(8)
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int a = Integer.parseInt(st.nextToken()); //번호
                int b = Integer.parseInt(st.nextToken()) - 1; //방향

                map[i][j] = a;
                fish[a] = new int[]{i, j, b};
            }
        }

        // 시작 0,0 , 0,0의 방향 그대로
        int eatIdx = map[0][0];
        int dir = fish[eatIdx][2];

        map[0][0] = 0;
        fish[eatIdx] = null;

        dfs(0, 0, dir, eatIdx, map, fish);

        System.out.println(max);
    }

    private static void dfs(int x, int y, int dir, int sum, int[][] baseMap, int[][] baseFish) {
        // 이동이 없으면 끝
        // 상어가 먹을 수있는 물고기 번호의 합 : 최대값
        max = Math.max(max, sum);

        int[][] map = new int[4][4];
        int[][] fish = new int[17][3];
        for (int i = 0; i < 4; i++) map[i] = baseMap[i].clone();
        for (int i = 0; i < 17; i++) {
            if (baseFish[i] != null) fish[i] = baseFish[i].clone();
            else fish[i] = null;
        }

        // 물고기 이동
        moveFish(x, y, map, fish);

        // 상어 이동 : 한번에 여러칸 가능 / 이동한 칸에 물고기가 있어야함
        int snx = x + dx[dir];
        int sny = y + dy[dir];
        while (inMap(snx, sny)) {
            // 이동할 수있는 칸들 모두 들어가기 -> dfs
            if (map[sny][snx] > 0) {
                int eatIdx = map[sny][snx];
                int[] eatFish = fish[eatIdx].clone();

                // 이동한 칸의 물고기를 먹고 + 물고기 방향을 가짐
                map[sny][snx] = 0;
                fish[eatIdx] = null;

                dfs(snx, sny, eatFish[2], sum + eatIdx, map, fish);

                // 이동하는중 지나가는 물고기 안먹음 - 복구
                map[sny][snx] = eatIdx;
                fish[eatIdx] = eatFish;
            }

            snx += dx[dir];
            sny += dy[dir];
        }
    }

    private static void moveFish(int sharkX, int sharkY, int[][] map, int[][] fish) {
        // 물고기 이동 : 번호 순대로 이동 : 빈칸, 다른물고기칸 - 상어x경계밖x
        for (int i = 1; i <= 16; i++) {
            if (fish[i] == null) continue; // 먹힌건 패스

            int y = fish[i][0];
            int x = fish[i][1];
            int dir = fish[i][2];

            // 방향찾기 : 반시계회전 -> 결정된거로 방향 바꿈
            for (int j = 0; j < 8; j++) {
                int nDir = (dir + j) % 8;
                int nx = x + dx[nDir];
                int ny = y + dy[nDir];

                if ((!inMap(nx, ny)) || (ny == sharkY && nx == sharkX)) continue;

                // 이동 가능
                if (map[ny][nx] != 0) {
                    // 다른 물고기 있으면 서로 위치 변경
                    int change = map[ny][nx];
                    map[y][x] = change;
                    fish[change][0] = y;
                    fish[change][1] = x;
                } else {
                    map[y][x] = 0;
                }
                fish[i] = new int[]{ny, nx, nDir};
                map[ny][nx] = i;
                break;
            }
        }
    }

    private static boolean inMap(int x, int y) {
        return x >= 0 && y >= 0 && x < 4 && y < 4;
    }
}
