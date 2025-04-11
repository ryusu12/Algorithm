import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(bufR.readLine());

        long domain1 = Long.parseLong(token.nextToken());
        long domain2 = Long.parseLong(token.nextToken());

        bufW.write(String.valueOf(Math.abs(domain1 - domain2)));
        bufW.flush();
        bufR.close();
        bufW.close();
    }
}