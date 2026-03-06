import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;

    static int sharkX;  // 상어위치
    static int sharkY;  // 상어위치
    static int sharkSize = 2; // 상어크기

    static PriorityQueue<int[]> fish;
    // 이동 : 위왼오아래
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // nxn map
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    sharkX = j;
                    sharkY = i;
                    map[i][j] = 0;
                }
            }
        }

        int countEat = 0;
        int time = 0;
        while(true) {
            // 물고기 정보 : y, x, size - 정렬 : 거리>위>왼
            fish = new PriorityQueue<>((a, b) -> {
                if (a[2] != b[2]) return a[2] - b[2];
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            });

            bfs();

            // 물고기 정보에서, 먹을수 있는 고기가 있는지
            if (!fish.isEmpty()) {
                int[] eat = fish.poll();
                // 갱신
                sharkY = eat[0];
                sharkX = eat[1];
                time += eat[2];
                map[eat[0]][eat[1]] = 0;
                countEat++;
                // 상어크기 == 먹음 횟수 ? 상어크기 ++; 먹음 횟수 = 0;
                if (sharkSize == countEat) {
                    sharkSize++;
                    countEat = 0;
                }
            } else break;
            // 없으면 break
        }

        System.out.println(time);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {sharkY, sharkX, 0});
        boolean[][] visited = new boolean[n][n];
        visited[sharkY][sharkX] = true;

        int min = Integer.MAX_VALUE;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];
            int time = now[2];

            // 최단거리만 확인
            if (time > min) break;

            // 먹을수있는 물고기 찾기
            if (map[y][x] > 0 && map[y][x] < sharkSize) {
                fish.add(new int[] {y, x, time});
                min = time;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                boolean inMap = nx >= 0 && ny >= 0 && nx < n && ny < n;
                // 상어 크기 < 물고기 크기 : 이동안됨
                if (!inMap || sharkSize < map[ny][nx] || visited[ny][nx]) continue;
                visited[ny][nx] = true;
                q.offer(new int[]{ny, nx, time+1});
            }
        }
    }
}
