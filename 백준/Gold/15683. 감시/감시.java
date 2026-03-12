import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;

    static int[][] map; // 0 빈칸 6 벽
    static List<int[]> cctv;
    // 시계방향
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        cctv = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // cctv 배열 : 번호, y좌표, x좌표
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctv.add(new int[]{map[i][j], i, j});
                }
            }
        }

        // cctv가 없을때
        answer = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 0) answer++;
            }
        }

        dfs(0, map);
        System.out.print(answer);
    }

    private static void dfs(int cIdx, int[][] map) {
        if (cIdx == cctv.size()) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) count++;
                }
            }
            answer = Math.min(answer, count);
            return;
        }

        int[] cur = cctv.get(cIdx);
        int num = cur[0];
        int y = cur[1];
        int x = cur[2];

        for (int i = 0; i < 4; i++) {
            int[][] nextMap = copy(map);
            if (num == 1) {
                mapCheck(y, x, i, nextMap);
            } else if (num == 2) {
                if (i >= 2) continue; // 2번은 상하/좌우 두 경우뿐
                mapCheck(y, x, i, nextMap);
                mapCheck(y, x, i+2, nextMap);
            } else if (num == 3) {
                mapCheck(y, x, i, nextMap);
                mapCheck(y, x, (i + 1) % 4, nextMap);
            } else if (num == 4) {
                mapCheck(y, x, i, nextMap);
                mapCheck(y, x, (i + 1) % 4, nextMap);
                mapCheck(y, x, (i + 2) % 4, nextMap);
            } else if (num == 5) {
                if (i >= 1) continue;
                mapCheck(y, x, 0, nextMap);
                mapCheck(y, x, 1, nextMap);
                mapCheck(y, x, 2, nextMap);
                mapCheck(y, x, 3, nextMap);
            }
            dfs(cIdx + 1, nextMap);
        }
    }

    private static void mapCheck(int y, int x, int idx, int[][] newMap) {
        int nx = x + dx[idx];
        int ny = y + dy[idx];
        // 쭉 감시 가능 / 벽 너머 불가
        while (ny >= 0 && ny < n && nx >= 0 && nx < m && newMap[ny][nx] != 6) {
            if (newMap[ny][nx] == 0) newMap[ny][nx] = -1; // 감시 구역 표시
            nx += dx[idx];
            ny += dy[idx];
        }
    }

    private static int[][] copy(int[][] map) {
        int[][] newMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            newMap[i] = map[i].clone();
        }
        return newMap;
    }
}
