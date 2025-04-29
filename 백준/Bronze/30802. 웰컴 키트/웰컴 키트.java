import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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
        bw.write(sum + "\n");
        bw.write(N / P + " " + (N % P));
        bw.flush();
        bw.close();
        br.close();
    }
}