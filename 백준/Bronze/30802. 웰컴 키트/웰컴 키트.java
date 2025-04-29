import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer token = new StringTokenizer(br.readLine());
        
        StringTokenizer token2 = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(token2.nextToken());
        int P = Integer.parseInt(token2.nextToken());

        int sum = 0;
        for (int i = 0; i < 6; i++) {
            int num = Integer.parseInt(token.nextToken());
            while (num > 0) {
                num -= T;
                sum += 1;
            }
        }
        output.append(sum).append('\n');
        output.append(N / P).append(" ").append(N % P);
        System.out.println(output);
    }
}