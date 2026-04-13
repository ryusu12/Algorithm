import java.io.*;
import java.util.*;

class Planet {
    int id, x, y, z;

    Planet(int id, int x, int y, int z) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Edge implements Comparable<Edge> {
    int sIdx, eIdx, dis;

    Edge(int sIdx, int eIdx, int dis) {
        this.sIdx = sIdx;
        this.eIdx = eIdx;
        this.dis = dis;
    }

    @Override
    public int compareTo(Edge e) {
        return Integer.compare(this.dis, e.dis);
    }
}

public class Main {

    static int n;
    static Planet[] planets;
    static List<Edge> edgeList;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        // 행성 정보 기입
        planets = new Planet[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets[i] = new Planet(i, x, y, z);
        }

        // 거리순으로 정렬
        edgeList = new ArrayList<>();
        getEdge();

        // 크루스칼 알고리즘
        getResult();
    }

    private static void getEdge() {
        // 각 좌표들에 대해 최소거리인 것끼리만 연결 - 각 좌표 거리 정렬 후 거리
        Arrays.sort(planets, (a, b) -> a.x - b.x);
        for (int i = 0; i < n - 1; i++) {
            edgeList.add(new Edge(planets[i].id, planets[i + 1].id, Math.abs(planets[i].x - planets[i + 1].x)));
        }

        Arrays.sort(planets, (a, b) -> a.y - b.y);
        for (int i = 0; i < n - 1; i++) {
            edgeList.add(new Edge(planets[i].id, planets[i + 1].id, Math.abs(planets[i].y - planets[i + 1].y)));
        }

        Arrays.sort(planets, (a, b) -> a.z - b.z);
        for (int i = 0; i < n - 1; i++) {
            edgeList.add(new Edge(planets[i].id, planets[i + 1].id, Math.abs(planets[i].z - planets[i + 1].z)));
        }

        Collections.sort(edgeList);
    }

    private static void getResult() {
        long sum = 0;
        int count = 0;

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (Edge e : edgeList) {
            if (findParent(e.sIdx) == findParent(e.eIdx)) continue;
            link(e.sIdx, e.eIdx);
            sum += e.dis;
            count++;
            if (count >= n - 1) break;
        }

        // 모두 연결하는데 드는 최소 비용
        System.out.println(sum);
    }

    private static int findParent(int now) {
        if (parent[now] == now) return now;
        return parent[now] = findParent(parent[now]);
    }

    private static void link(int s, int e) {
        s = findParent(s);
        e = findParent(e);
        parent[e] = s;
    }
}
