import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int s, e, dis;

    Edge(int s, int e, int dis) {
        this.s = s;
        this.e = e;
        this.dis = dis;
    }

    @Override
    public int compareTo(Edge e) {
        return Integer.compare(this.dis, e.dis);
    }
}

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] island;
    static int[] parent;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 정보 저장 : bfs
        island = new int[n][m];
        int landNum = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && island[i][j] == 0) {
                    bfs(i, j, landNum++);
                }
            }
        }

        // 다리 건설 가능한 곳 찾기
        List<Edge> bridge = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 현재 섬이면 : 상하좌우 쭉 이동해서 섬 확인하기
                if (map[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nx = j;
                        int ny = i;
                        int dis = 0;

                        while (true) {
                            nx += dx[k];
                            ny += dy[k];
                            // 범위 밖이거나, 같은 섬이면 다른 방향으로 찾기
                            if (!inMap(nx, ny) || island[ny][nx] == island[i][j]) break;
                            // 다른 섬인데, 거리가 2 이상이면 건설 가능 - 다른거 찾기 / 거리미달 : 다른 방향으로
                            if (island[ny][nx] != 0) {
                                if (dis >= 2) {
                                    bridge.add(new Edge(island[i][j], island[ny][nx], dis));
                                }
                                break;
                            }
                            dis++;
                        }
                    }
                }
            }
        }
        Collections.sort(bridge);
        // 크루스칼
        parent = new int[landNum + 1];
        for (int i = 1; i < landNum + 1; i++) {
            parent[i] = i;
        }

        int sum = 0;
        int count = 0;
        for (Edge b : bridge) {
            if (find(b.s) == find(b.e)) continue;
            link(b.s, b.e);
            sum += b.dis;
            count++;
            if(count >= landNum - 2) break;
        }

        // 다리 길이의 최소값
        System.out.println(count == landNum - 2 ? sum : -1);
    }

    private static int find(int now) {
        if (parent[now] == now) return now;
        return parent[now] = find(parent[now]);
    }

    private static void link(int s, int e) {
        s = parent[s];
        e = parent[e];
        parent[e] = s;
    }

    private static void bfs(int y, int x, int target) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        island[y][x] = target;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[1] + dx[i];
                int ny = now[0] + dy[i];
                if (!inMap(nx, ny) || island[ny][nx] != 0 || map[ny][nx] != 1) continue;
                island[ny][nx] = target;
                q.offer(new int[]{ny, nx});
            }
        }
    }

    private static boolean inMap(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
