import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(bufferedReader.readLine());
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();

        bufferedWriter.close();
        bufferedReader.close();
    }
}