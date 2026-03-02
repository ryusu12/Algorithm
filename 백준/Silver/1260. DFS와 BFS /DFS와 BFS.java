import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int V = Integer.parseInt(token.nextToken());

        // 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다
        boolean[][] link = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            link[a][b] = true;
            link[b][a] = true;
        }

        // 첫째 줄에 DFS를 수행한 결과를, 그다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
        // 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
        boolean[] visited = new boolean[N + 1];
        visited[V] = true;
        dfs(V, link, visited);
        System.out.println();

        visited = new boolean[N + 1];
        visited[V] = true;
        bfs(V, link, visited);
    }

    private static void dfs(int now, boolean[][] link, boolean[] visited) {
        System.out.print(now + " ");

        for (int i = 0; i < link.length; i++) {
            if (link[now][i] && !visited[i]) {
                visited[i] = true;
                dfs(i, link, visited);
            }
        }
    }

    private static void bfs(int start, boolean[][] link, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");

            for (int i = 0; i < link.length; i++) {
                if (link[now][i] && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
