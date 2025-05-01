import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int H = Integer.parseInt(token.nextToken());
        int I = Integer.parseInt(token.nextToken());

        int A = Integer.parseInt(token.nextToken());
        int R = Integer.parseInt(token.nextToken());
        int C = Integer.parseInt(token.nextToken());

        System.out.println(H * I - A * R * C);
    }
}