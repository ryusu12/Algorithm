import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if(str == null) break;
            output.append(str).append("\n");
        }
        System.out.println(output);
    }
}