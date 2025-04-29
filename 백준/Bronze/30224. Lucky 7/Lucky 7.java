import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        String strNum = br.readLine();
        int num = Integer.parseInt(strNum);
        if (strNum.contains("7")) {
            if (((num % 7) != 0)) {
                output.append(2);
            } else {
                output.append(3);
            }
        } else {
            if (((num % 7) != 0)) {
                output.append(0);
            } else {
                output.append(1);
            }
        }

        System.out.println(output);
    }
}