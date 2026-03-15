import java.io.*;
import java.util.*;

public class Main {
    
    static int n, m, t;
    static List<List<Integer>> circle;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        circle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            circle.add(list);
        }

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 원판 선정 : x 배수
            int d = Integer.parseInt(st.nextToken()); // 0시계 1반시계
            int k = Integer.parseInt(st.nextToken()); // 회전 칸

            // 회전
            move(x, k, d);

            // 인접하면서 같은수 찾기 -- 같은수 모두 삭제
            boolean isSame = findSame();
            // 같은수 없으면 원판 평균보다 크면 -1, 작으면 +1
            if (!isSame) setByAvg();
        }

        // 원판의 모든 수 합
        getSum();
    }

    private static void move(int x, int k, int d) {
        for (int i = x; i <= n; i += x) {
            List<Integer> list = circle.get(i - 1);
            for (int j = 0; j < k; j++) {
                if (d == 0) {
                    list.add(0, list.remove(m - 1));
                } else {
                    list.add(list.remove(0));
                }
            }
        }
    }

    private static boolean findSame() {
        boolean[][] remove = new boolean[n][m];
        boolean isSame = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (circle.get(i).get(j).equals(0)) continue;

                // 인접: 같은 원안에서 양옆, 다른원과 마주보고있는것
                if (circle.get(i).get(j).equals(circle.get(i).get((j + 1) % m))) {
                    remove[i][j] = true;
                    remove[i][(j + 1) % m] = true;
                    isSame = true;
                }
                if (i < n - 1 && circle.get(i).get(j).equals(circle.get(i + 1).get(j))) {
                    remove[i][j] = true;
                    remove[i + 1][j] = true;
                    isSame = true;
                }
            }
        }
        // 한꺼번에 삭제하기
        if (isSame) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (remove[i][j]) circle.get(i).set(j, 0);
                }
            }
        }
        return isSame;
    }

    private static void setByAvg() {
        // 원판 평균 구하기
        double sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (circle.get(i).get(j).equals(0)) continue;
                sum += circle.get(i).get(j);
                count++;
            }
        }
        if (count == 0) return;
        double avg = sum / count;
        
        // 같은수 없으면 원판 평균보다 크면 -1, 작으면 +1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (circle.get(i).get(j).equals(0)) continue;

                if (circle.get(i).get(j) > avg) {
                    circle.get(i).set(j, circle.get(i).get(j) - 1);
                } else if (circle.get(i).get(j) < avg) {
                    circle.get(i).set(j, circle.get(i).get(j) + 1);
                }
            }
        }
    }

    private static void getSum() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += circle.get(i).get(j);
            }
        }
        System.out.println(sum);
    }
}
