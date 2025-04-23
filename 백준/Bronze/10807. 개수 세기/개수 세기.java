import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < N; i++) {
            String num = token.nextToken();
            list.add(num);
        }
        String V = br.readLine();
        long count = list.stream().filter(num -> num.equals(V)).count();

        output.append(count);
        System.out.println(output);
        br.close();
    }
}