import java.io.*;
import java.util.*;

public class Main {

    static int n, e;
    static Map<Integer, List<int[]>> edge;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        edge = new HashMap<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            // 양방향
            List<int[]> listA = edge.getOrDefault(a, new ArrayList<>());
            List<int[]> listB = edge.getOrDefault(b, new ArrayList<>());
            listA.add(new int[]{b, len});
            listB.add(new int[]{a, len});
            edge.put(a, listA);
            edge.put(b, listB);
        }

        // 반드시 거쳐야하는 간선
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> N
        // 1 -> v2 -> v1 -> N
        int[] arr1 = dk(1);
        int[] arrV1 = dk(v1);
        int[] arrV2 = dk(v2);

        long result = Math.min((long) arr1[v1] + arrV1[v2]  + arrV2[n], (long) arr1[v2] + arrV2[v1]  + arrV1[n]);
        if (result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.print(result);
    }

    public static int[] dk(int start) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int v = now[0];
            int w = now[1];

            if (arr[v] < w) continue;

            if (edge.containsKey(v)) {
                for (int[] next : edge.get(v)) {
                    int nv = next[0];
                    int nw = next[1];

                    if (arr[nv] > w + nw) {
                        arr[nv] = w + nw;
                        pq.offer(new int[]{nv, arr[nv]});
                    }
                }
            }
        }
        return arr;
    }
}
