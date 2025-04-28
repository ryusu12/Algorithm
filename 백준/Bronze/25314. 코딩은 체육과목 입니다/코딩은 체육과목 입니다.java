import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        do {
            output.append("long ");
            num -= 4;
        } while (num > 0);

        output.append("int");
        System.out.println(output);
    }
}