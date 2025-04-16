import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length; i++) {
            StringTokenizer token = new StringTokenizer(bufferedReader.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            builder.append(a + b).append("\n");
        }
        System.out.println(builder);
        bufferedReader.close();
    }
}