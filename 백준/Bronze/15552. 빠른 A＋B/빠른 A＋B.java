import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int length = Integer.parseInt(br.readLine());
        for (int i = 0; i < length; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(token.nextToken());
            int B = Integer.parseInt(token.nextToken());
            output.append(A + B).append("\n");
        }
        System.out.println(output);
        br.close();
    }
}