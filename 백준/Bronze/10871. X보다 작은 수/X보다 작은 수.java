import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        StringTokenizer first_token = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(first_token.nextToken());
        int X = Integer.parseInt(first_token.nextToken());

        StringTokenizer second_token = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(second_token.nextToken());
            if(X > num) {
                output.append(num).append(" ");
            }
        }
        System.out.println(output);
        br.close();
    }
}