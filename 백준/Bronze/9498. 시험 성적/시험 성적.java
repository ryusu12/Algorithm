import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer read = new StringTokenizer(bufR.readLine(), " ");

        int score = Integer.parseInt(read.nextToken());
        char result;
        if (score >= 90) {
            result = 'A';
        } else if (score >= 80) {
            result = 'B';
        } else if (score >= 70) {
            result = 'C';
        } else if (score >= 60) {
            result = 'D';
        } else {
            result = 'F';
        }
        bufW.write(result);
        bufW.flush();
        bufR.close();
        bufW.close();
    }
}