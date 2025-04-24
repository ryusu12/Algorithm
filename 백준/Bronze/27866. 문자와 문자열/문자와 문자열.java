import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        String word = br.readLine();
        int index = Integer.parseInt(br.readLine()) - 1;

        output.append(word.charAt(index));
        System.out.println(output);
    }
}