import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            // 무게 j의 최댓값 : 지금것 넣을때 <> 안넣을때(원래)
            for (int j = K; j >= W; j--) {
                arr[j] = Math.max(arr[j - W] + V, arr[j]);
            }
        }

        System.out.println(arr[K]);
    }
}
