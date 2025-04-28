import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        long A = Integer.parseInt(token.nextToken());
        long B = Integer.parseInt(token.nextToken());

        output.append((A + B) * (A - B));

        System.out.println(output);
    }
}