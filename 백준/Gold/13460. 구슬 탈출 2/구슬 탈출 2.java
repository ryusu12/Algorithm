import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int rx = 0;
        int ry = 0;
        int bx = 0;
        int by = 0;

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                // 공 좌표 기록
                if (map[i][j] == 'R') {
                    ry = i;
                    rx = j;
                } else if (map[i][j] == 'B') {
                    by = i;
                    bx = j;
                }
            }
        }

        // 파란구슬 -> 구멍 x, 빨간구슬 -> 구멍
        System.out.print(bfs(ry, rx, by, bx));
    }

    private static int bfs(int sry, int srx, int sby, int sbx) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {sry, srx, sby, sbx, 0});

        boolean[][][][] visited = new boolean[N][M][N][M];
        visited[sry][srx][sby][sbx] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int count = now[4];
            
            if (count >= 10) return -1;

            // 두 공 동시 이동
            for (int i = 0; i < 4; i++) {
                // 빨간공 이동
                int nry = now[0];
                int nrx = now[1];
                while (map[nry + dy[i]][nrx + dx[i]] != '#') {
                    nry += dy[i];
                    nrx += dx[i];
                    if (map[nry][nrx] == 'O') break;
                }

                // 파란공 이동
                int nby = now[2];
                int nbx = now[3];
                while (map[nby + dy[i]][nbx + dx[i]] != '#') {
                    nby += dy[i];
                    nbx += dx[i];
                    if (map[nby][nbx] == 'O') break;
                }

                // 구슬이 구멍일때 return
                if (map[nby][nbx] == 'O') continue;
                if (map[nry][nrx] == 'O') return count + 1;

                // 공이 같은 위치 : 먼저오면 선점 - 짧게 온게 선점
                if (nry == nby && nrx == nbx) {
                    int rDist = Math.abs(nry - now[0]) + Math.abs(nrx - now[1]);
                    int bDist = Math.abs(nby - now[2]) + Math.abs(nbx - now[3]);

                    if (rDist > bDist) {
                        nry -= dy[i];
                        nrx -= dx[i];
                    }
                    else {
                        nby -= dy[i];
                        nbx -= dx[i];
                    }
                }
                
                if (!visited[nry][nrx][nby][nbx]) {
                    visited[nry][nrx][nby][nbx] = true;
                    q.offer(new int[] {nry, nrx, nby, nbx, count + 1});
                }
            }
        }
        return -1;
    }
}
