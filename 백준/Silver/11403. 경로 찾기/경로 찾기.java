import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] link;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        link = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                link[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            dfs(i, i, new boolean[N]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int start, int now, boolean[] visited) {
        for (int i = 0; i < N; i++) {
            if (link[now][i] == 1 && !visited[i]) {
                visited[i]= true;
                map[start][i] = 1;
                dfs(start, i, visited);
            }
        }
    }
}
