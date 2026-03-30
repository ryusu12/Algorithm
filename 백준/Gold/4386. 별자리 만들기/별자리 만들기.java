import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int start;
    int end;
    double dis;

    Edge(int start, int end, double dis) {
        this.start = start;
        this.end = end;
        this.dis = dis;
    }

    @Override
    public int compareTo(Edge e) {
        return Double.compare(this.dis, e.dis);
    }
}

public class Main {
    static int n;
    static double[][] star;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        star = new double[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            star[i][0] = x;
            star[i][1] = y;
        }

        // 거리 오름차순 저장
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                double len = Math.sqrt(Math.pow(star[i][0] - star[j][0], 2) + Math.pow(star[i][1] - star[j][1], 2));
                edges.add(new Edge(i, j, len));
            }
        }
        edges.sort((a, b) -> a.compareTo(b));

        // 거리 최소 비용
        double dis = 0;
        int count = 0;

        // 부모를 자기 자신으로 초기화
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (Edge e : edges) {
            // 부모가 달라야함
            if (findParent(e.start) == findParent(e.end)) continue;
            link(e.start, e.end);
            dis += e.dis;
            count++;

            if (count == n - 1) break;
        }

        System.out.printf("%.2f", dis);
    }

    public static int findParent(int now) {
        if (parent[now] == now) return now;
        return parent[now] = findParent(parent[now]);
    }

    public static void link(int s, int e) {
        s = findParent(s);
        e = findParent(e);
        parent[e] = s;
    }
}
