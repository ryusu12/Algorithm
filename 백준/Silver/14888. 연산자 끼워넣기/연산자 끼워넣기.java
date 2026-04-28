import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr, oper;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        oper = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1, 0);

        System.out.println(max + "\n" + min);
    }

    private static void dfs(int sum, int now, int count) {
        if (count == n - 1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (oper[i] > 0) {
                oper[i]--;
                dfs(calculate(i, sum, arr[now]), now + 1, count + 1);
                oper[i]++;
            }
        }
    }

    private static int calculate(int idx, int a, int b) {
        if (idx == 0) {
            return a + b;
        } else if (idx == 1) {
            return a - b;
        } else if (idx == 2) {
            return a * b;
        } else {
            return a / b;
        }
    }
}