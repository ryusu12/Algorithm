import java.io.*;
import java.util.*;

class Num implements Comparable<Num> {
    int n;
    int c;

    public Num(int n, int c) {
        this.n = n;
        this.c = c;
    }

    @Override
    public int compareTo(Num o) {
        if (this.c == o.c) return this.n - o.n;
        return this.c - o.c;
    }
}

public class Main {

    static int r, c, k;
    static int[][] map = new int[101][101];
    static int row = 3;
    static int col = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        k = sc.nextInt();

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 모두 수행했을때의 목표값까지의 최소값
        int time = 0;
        while (time <= 100) {
            if (map[r][c] == k) {
                System.out.println(time);
                return;
            }

            // 연산 종류
            if (row >= col) {
                sortR();
            } else {
                sortC();
            }
            time++;
        }

        System.out.print(-1);
    }

    // 3 1 1 -> [3,1]  [1,2] -> 31/12
    // [3,1] [1,2] [2,1] -> [2,1][3,1][1,2]

    private static void sortR() {
        int len = 0;

        for (int i = 1; i <= row; i++) {
            // [등장숫자, 등장횟수] 저장
            Map<Integer, Integer> number = new HashMap<>();
            for (int j = 1; j <= col; j++) {
                if (map[i][j] == 0) continue; // 0 무시
                number.put(map[i][j], number.getOrDefault(map[i][j], 0) + 1);
            }

            // 등장 횟수 오름차 -> 등장 숫자 오름차
            List<Num> list = new ArrayList<>();
            for (Integer key : number.keySet()) {
                list.add(new Num(key, number.get(key)));
            }
            Collections.sort(list);

            // 초기화
            for (int j = 1; j <= 100; j++) map[i][j] = 0;
            // 채우기
            int idx = 1;
            for (Num num : list) {
                if (idx > 100) break;
                map[i][idx++] = num.n;
                if (idx > 100) break;
                map[i][idx++] = num.c;
            }
            len = Math.max(len, idx - 1);
        }
        col = len;
    }

    private static void sortC() {
        int len = 0;

        for (int j = 1; j <= col; j++) {
            // [등장숫자, 등장횟수] 저장
            Map<Integer, Integer> number = new HashMap<>();
            for (int i = 1; i <= row; i++) {
                if (map[i][j] == 0) continue; // 0 무시
                number.put(map[i][j], number.getOrDefault(map[i][j], 0) + 1);
            }

            // 등장 횟수 오름차 -> 등장 숫자 오름차
            List<Num> list = new ArrayList<>();
            for (Integer key : number.keySet()) {
                list.add(new Num(key, number.get(key)));
            }
            Collections.sort(list);

            // 초기화
            for (int i = 1; i <= 100; i++) map[i][j] = 0;
            // 채우기
            int idx = 1;
            for (Num num : list) {
                if (idx > 100) break;
                map[idx++][j] = num.n;
                if (idx > 100) break;
                map[idx++][j] = num.c;
            }
            len = Math.max(len, idx - 1);
        }
        row = len;
    }
}
