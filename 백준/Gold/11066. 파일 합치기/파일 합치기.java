import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());

            // 2개씩 합침 -> 3개씩 합침 ->,...
            int[] sum = new int[k + 1];
            // 누적합 중 최소 - 누적합 : arr[k+1][k+1] -> 0 기본
            int[][] dp = new int[k + 1][k + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= k; j++) {
                sum[j] = sum[j - 1] + Integer.parseInt(st.nextToken());
            }

            // 합칠 수
            for (int len = 2; len <= k; len++) {
                // 시작 위치
                for (int s = 1; s <= k - len + 1; s++) {
                    int e = s + len - 1; // 끝 위치
                    dp[s][e] = Integer.MAX_VALUE;

                    // 중간에 합치는 위치
                    for (int m = s; m < e; m++) {
                        // 이전s~m비용 + 이전m~e 비용 + 현재e~s 비용
                        int cost = dp[s][m] + dp[m+1][e] + sum[e] - sum[s-1];
                        dp[s][e] = Math.min(dp[s][e], cost);
                    }
                }
            }
            System.out.println(dp[1][k]);
        }
    }
}
