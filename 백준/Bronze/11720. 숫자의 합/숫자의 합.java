import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int length = Integer.parseInt(br.readLine());
        String strNum = br.readLine();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += strNum.charAt(i) - '0';
        }
        output.append(sum);
        System.out.println(output);
    }
}