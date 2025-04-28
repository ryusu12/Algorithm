import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        
        int num = 5;
        long result = 0;
        
        while (num > 0) {
            result += (int) Math.pow(Integer.parseInt(token.nextToken()), 2);
            num--;
        }
        
        output.append(result % 10);
        System.out.println(output);
    }
}