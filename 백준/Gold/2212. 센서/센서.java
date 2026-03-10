import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] sensor = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sensor[i] = Integer.parseInt(st.nextToken());
        }
        // 센서 좌표 정렬
        Arrays.sort(sensor);

        int[] len = new int[n - 1];
        // 센서 사이의 거리
        for (int i = 0; i < n - 1; i++) {
            len[i] = sensor[i+1] - sensor[i];
        }

        // 전체 합중에서 긴거 제외 (정렬) : k-1번 끊음
        Arrays.sort(len);
        for (int i = 0; i < (n - 1) - (k - 1); i++) {
            sum += len[i];
        }
        System.out.print(sum);
    }
}
