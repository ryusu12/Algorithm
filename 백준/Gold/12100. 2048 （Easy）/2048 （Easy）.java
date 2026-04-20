import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 다음 단계 : 횟수 차감,
        dfs(map, 0);

        System.out.println(answer);
    }

    private static void dfs(int[][] map, int count) {
        if (count >= 5) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    answer = Math.max(answer, map[i][j]);
                }
            }
            return;
        }

        // 방향 정하기 : 상하좌우
        for (int d = 0; d < 4; d++) {
            int[][] newMap = new int[n][n];
            for (int i = 0; i < n; i++) newMap[i] = map[i].clone();

            // 방향대로 쭉 밀기 : 안쪽부터 갱신
            move(d, newMap);

            dfs(newMap, count + 1);
        }
    }

    private static void move(int d, int[][] map) {
        if (d == 0) { // 상 (0 행)
            for (int j = 0; j < n; j++) {
                Queue<Integer> q = new LinkedList<>();
                for (int i = 0; i < n; i++) {
                    if (map[i][j] != 0) q.offer(map[i][j]); // 큐에 삽입 : 0 제외 - 밀린상태로 됨
                    map[i][j] = 0;
                }
                int idx = 0;
                while (!q.isEmpty()) {
                    int now = q.poll();
                    if (map[idx][j] == 0) map[idx][j] = now; // 맨 첫번째는 그대로 다시 넣어주기
                    else if (map[idx][j] == now) {
                        // 숫자 만나면 갱신해서 넣거나, 다음 칸에 넣음
                        map[idx][j] = now * 2;
                        idx++;
                    } else {
                        idx++;
                        map[idx][j] = now;
                    }
                }
            }
        } else if (d == 1) { // 하 (N-1 행)
            for (int j = 0; j < n; j++) {
                Queue<Integer> q = new LinkedList<>();
                for (int i = n - 1; i >= 0; i--) {
                    if (map[i][j] != 0) q.offer(map[i][j]); // 큐에 삽입 : 0 제외 - 밀린상태로 됨
                    map[i][j] = 0;
                }
                int idx = n - 1;
                while (!q.isEmpty()) {
                    int now = q.poll();
                    if (map[idx][j] == 0) map[idx][j] = now; // 맨 첫번째는 그대로 다시 넣어주기
                    else if (map[idx][j] == now) {
                        map[idx][j] = now * 2;
                        idx--;
                    } else {
                        idx--;
                        map[idx][j] = now;
                    }
                }
            }
        } else if (d == 2) { // 좌 (0 열)
            for (int i = 0; i < n; i++) {
                Queue<Integer> q = new LinkedList<>();
                for (int j = 0; j < n; j++) {
                    if (map[i][j] != 0) q.offer(map[i][j]); // 큐에 삽입 : 0 제외 - 밀린상태로 됨
                    map[i][j] = 0;
                }
                int idx = 0;
                while (!q.isEmpty()) {
                    int now = q.poll();
                    if (map[i][idx] == 0) map[i][idx] = now; // 맨 첫번째는 그대로 다시 넣어주기
                    else if (map[i][idx] == now) {
                        map[i][idx] = now * 2;
                        idx++;
                    } else {
                        idx++;
                        map[i][idx] = now;
                    }
                }
            }
        } else { // 우 (N-1 열)
            for (int i = 0; i < n; i++) {
                Queue<Integer> q = new LinkedList<>();
                for (int j = n - 1; j >= 0; j--) {
                    if (map[i][j] != 0) q.offer(map[i][j]); // 큐에 삽입 : 0 제외 - 밀린상태로 됨
                    map[i][j] = 0;
                }
                int idx = n - 1;
                while (!q.isEmpty()) {
                    int now = q.poll();
                    if (map[i][idx] == 0) map[i][idx] = now; // 맨 첫번째는 그대로 다시 넣어주기
                    else if (map[i][idx] == now) {
                        map[i][idx] = now * 2;
                        idx--;
                    } else {
                        idx--;
                        map[i][idx] = now;
                    }
                }
            }
        }
    }
}