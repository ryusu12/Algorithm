import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        StringTokenizer token =  new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            int[] row = new int[M];
            token =  new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(token.nextToken());
                row[j] = num;
            }
            arr[i] = row;
        }
        for (int i = 0; i < N; i++) {
            token =  new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(token.nextToken());
                arr[i][j] += num;
                output.append(arr[i][j]).append(" ");
            }
            output.append("\n");
        }

        System.out.println(output);
        br.close();
    }
}