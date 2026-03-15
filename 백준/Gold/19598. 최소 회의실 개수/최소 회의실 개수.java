import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] meeting = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        // 시작 시간 기준 정렬
        Arrays.sort(meeting, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        // 진행중인 회의 리스트 [종료시간]
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(meeting[0][1]);

        for (int i = 1; i < n; i++) {
            // 다음 회의 시작 >= 현재 회의 종료 : 회의 종료됐으니 비워줌
            if (!pq.isEmpty() && meeting[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.offer(meeting[i][1]);
        }
        System.out.print(pq.size());
    }
}
