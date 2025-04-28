import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public boolean check (int a, int b, int c) {
        return  Math.pow(a,2) + Math.pow(b,2) == Math.pow(c,2);
    }
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        while (true) {
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());

            if(a == 0 && b ==0 && c ==0) break;

            String result;
            if (main.check(a, b, c)) result = "right";
            else if (main.check(b, c, a)) result = "right";
            else if (main.check(a, c, b)) result = "right";
            else result = "wrong";
            output.append(result).append('\n');
        }
        System.out.println(output);
    }
}