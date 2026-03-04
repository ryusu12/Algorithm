import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(token.nextToken());
        int C = Integer.parseInt(token.nextToken());
        int T = Integer.parseInt(token.nextToken());

        int[][] map = new int[R][C];
        int[][] machine = new int[2][2];
        int idx = 0;
        for (int i = 0; i < R; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
                if (map[i][j] == -1) {
                    machine[idx][0] = i;
                    machine[idx][1] = j;
                    idx++;
                }
            }
        }

        // 시간이 지남에 따라
        for (int t = 0; t < T; t++) {
            // 미세먼지 확산: 현재칸의 /5 : 상하좌우 (맵 범위내에서, 공기청정기 제외)
            map = spread(R, C, map);
            // 공기청정기 작동
            clean(machine, map, C, R);
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) answer += map[i][j];
            }
        }

        System.out.println(answer);
    }

    private static void clean(int[][] machine, int[][] map, int C, int R) {
        // 위쪽은 반시계방향 순환
        int top = machine[0][0];
        for (int i = top - 1; i > 0; i--) map[i][0] = map[i - 1][0];
        for (int i = 0; i < C - 1; i++) map[0][i] = map[0][i + 1];
        for (int i = 0; i < top; i++) map[i][C - 1] = map[i + 1][C - 1];
        for (int i = C - 1; i > 1; i--) map[top][i] = map[top][i - 1];
        map[top][1] = 0;

        // 아래쪽은 시계방향 순환
        int bottom = machine[1][0];
        for (int i = bottom + 1; i < R - 1; i++) map[i][0] = map[i + 1][0];
        for (int i = 0; i < C - 1; i++) map[R - 1][i] = map[R - 1][i + 1];
        for (int i = R - 1; i > bottom; i--) map[i][C - 1] = map[i - 1][C - 1];
        for (int i = C - 1; i > 1; i--) map[bottom][i] = map[bottom][i - 1];
        map[bottom][1] = 0;
    }

    private static int[][] spread(int R, int C, int[][] map) {
        int[][] nextMap = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    nextMap[i][j]  = -1;
                    continue;
                }
                if (map[i][j] > 0) {
                    int size = map[i][j] / 5;
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = j + dx[k];
                        int ny = i + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < C && ny < R && map[ny][nx] != -1) {
                            nextMap[ny][nx] += size;
                            count++;
                        }
                    }
                    nextMap[i][j] += map[i][j] - (count * size);
                }
            }
        }
        return nextMap;
    }
}
