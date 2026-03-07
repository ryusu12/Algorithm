import java.io.*;
import java.util.*;

public class Main {
    
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {1, 0, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int size = n*n;

        int[] students = new int[size];
        Map<Integer, Set<Integer>> likes = new HashMap<>();
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            students[i] = Integer.parseInt(st.nextToken());
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 4; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            likes.put(students[i], set);
        }

        // nn map 생성
        int[][] map = new int[n][n];

        // y, x, like, empty
        // primaryQueue pq : like -> empty -> y -> x
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) return b[2] - a[2];
            if (a[3] != b[3]) return b[3] - a[3];
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        for (int student : students) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    // 이미 있는것 제외
                    if (map[y][x] != 0) continue;

                    int like = 0;
                    int empty = 0;

                    // 다음 이동할 칸들 모두 확인
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        boolean inMap = nx >= 0 && ny >= 0 && nx < n && ny < n;
                        if (inMap) {
                            if (map[ny][nx] == 0) empty++;
                            else if (likes.get(student).contains(map[ny][nx])) like++;
                        }
                    }
                    pq.add(new int[]{y, x, like, empty});
                }
            }

            // pq 맨앞이 들어갈곳
            if (!pq.isEmpty()) {
                int[] now = pq.poll();
                map[now[0]][now[1]] = student;
            }

            pq.clear();
        }

        // 만족도 총합 구하기
        int sum = 0;
        int[] scores = {0, 1, 10, 100, 1000};

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                int like = 0;
                // 다음 이동할 칸들 모두 확인
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    boolean inMap = nx >= 0 && ny >= 0 && nx < n && ny < n;
                    if (inMap && likes.get(map[y][x]).contains(map[ny][nx])) like++;
                }
                sum += scores[like];
            }
        }

        System.out.print(sum);
    }
}
