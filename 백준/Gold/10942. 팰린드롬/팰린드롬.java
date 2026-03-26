import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] num;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 팰린드 체크 배열 - t 1, f -1, 미확인 0
        int[][] check = setCheckArr();

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;

            sb.append(check[s][e]).append('\n');
        }
        System.out.println(sb);
    }

    private static int[][] setCheckArr() {
        int[][] check = new int[n][n];

        // S~E까지가 팰린드? -> Y OR N
        // 1글자면 y
        for (int i = 0; i < n; i++) check[i][i] = 1;

        // 2글자면 직접 확인
        for (int i = 0; i < n - 1; i++) {
            if (num[i] == num[i + 1]) check[i][i + 1] = 1;
        }

        // 그 이상이면 안쪽이 다 y여야함
        for (int len = 2; len < n; len++) {
            for (int s = 0; s + len <= n - 1; s++) {
                int e = s + len;
                if (num[s] == num[e] && check[s + 1][e - 1] == 1) {
                    check[s][e] = 1;
                }
            }
        }

        return check;
    }
}
