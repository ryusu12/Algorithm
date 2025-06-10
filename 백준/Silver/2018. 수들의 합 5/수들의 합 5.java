import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sum = 1;
        int count = 1;
        int start = 1;
        int end = 2;

        while (end <= N) {
            if (sum < N) {
                sum += end++;
            } else if (sum == N) {
                sum += end++;
                count++;
            } else {
                sum -= start++;
            }
        }
        System.out.println(count);
    }
}