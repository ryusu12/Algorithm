import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long count = 0;
        for (int a : arr) {
            // 총감독관 감시 가능 수 빼기 : 인원 ++
            int num = a - b;
            count++;

            // 남은 수가 <= 0 아니면 / 부감독관 감시 가능수 나누기 -> 인원
            if (num > 0) {
                count += (num % c == 0) ? (num / c) : (num / c) + 1;
            }
        }

        System.out.println(count);
    }
}