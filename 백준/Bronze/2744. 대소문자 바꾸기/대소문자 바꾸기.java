import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        String word = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            char one = word.charAt(i);
            if (Character.isUpperCase(one)){
                output.append(Character.toLowerCase(one));
            } else {
                output.append(Character.toUpperCase(one));
            }
        }
        System.out.println(output);
    }
}