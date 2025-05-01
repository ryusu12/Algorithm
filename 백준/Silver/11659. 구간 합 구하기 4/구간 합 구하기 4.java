import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        arr[0] = Integer.parseInt(token.nextToken());
        for (int i = 1; i < N; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(token.nextToken());
        }

        int sum;
        for (int k = 0; k < M; k++) {
            token = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(token.nextToken());
            int j = Integer.parseInt(token.nextToken());
            sum = i > 1 ? arr[j-1] - arr[i-2] : arr[j-1];
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}