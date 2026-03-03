import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 배열 갱신
        int[] sum = new int[n];

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(token.nextToken());
        sum[0] = num;
        int max = num;

        for (int i = 1; i < n; i++) {
            num = Integer.parseInt(token.nextToken());
            // 더할때와 안더했을때의 큰값 갱신
            sum[i] = Math.max(num, sum[i - 1] + num);
            // 이전값과 현재 값 비교
            max = Math.max(max, sum[i]);
        }

        System.out.println(max);
    }
}
