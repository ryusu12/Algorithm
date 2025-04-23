import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            if (a == 0 && b == 0) {
                break;
            } else {
                stringBuilder.append(a + b).append("\n");
            }
        }
        System.out.println(stringBuilder);
    }
}