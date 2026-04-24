import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        int[] dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        // 거꾸로 계산
        for (int i = n; i >= 0; i--) {
            int nd = i + t[i];

            // 이전날꺼 가능함 : 오늘꺼 vs 이전꺼 점수 갱신
            if (nd <= n + 1) {
                dp[i] = Math.max(p[i] + dp[nd], dp[i + 1]);
            } else {
                // 불가능함 : 오늘거로 함
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);
    }
}
