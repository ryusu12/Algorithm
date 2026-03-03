import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        // 보드
        int[][] map = new int[N][N];
        for (int i = 0; i < K; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(token.nextToken());
            int col = Integer.parseInt(token.nextToken());
            // 사과 위치 1
            map[row - 1][col - 1] = 1;
        }

        Map<Integer, String> move = new HashMap<>();
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(token.nextToken());
            String c = token.nextToken();
            // 방향변환 정보 : 이동시간, 방향
            move.put(x, c);
        }

        // 시계방향 회전
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int d = 0; // 오른쪽진행

        int x = 0;
        int y = 0;

        Deque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[]{x, y});
        map[x][y] = 2;

        int time = 0;

        while (true) {
            time ++;

            int nx = x + dx[d];
            int ny = y + dy[d];

            // 큐에 있는 몸이랑 좌표가 같으면 / 벽에 닿음 : 종료
            boolean inMap = nx >= 0 && ny >= 0 && nx < N && ny < N;
            if (!inMap || map[nx][ny] == 2) {
                break;
            }

            // 현재 위치가 사과있음 : 몸 길이+
            // 아니면 이동해서 꼬리 좌표 사라지기
            if (map[nx][ny] != 1) {
                int[] tail = snake.pollLast();
                map[tail[0]][tail[1]] = 0;
            }

            map[nx][ny] = 2;
            snake.offerFirst(new int[]{nx, ny});
            x = nx;
            y = ny;

            // 방향회전 순간
            if (move.containsKey(time)) {
                String spin = move.get(time);
                if (spin.equals("D")) {
                    d = (d + 1) % 4;
                } else {
                    d = (d + 3) % 4;
                }
            }
        }
        System.out.println(time);
    }
}
