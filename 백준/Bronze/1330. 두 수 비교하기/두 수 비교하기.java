import java.io.*;
import java.util.*;

// BufferedReader 연습
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in)); // scanner
        BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out)); // print

        StringTokenizer read = new StringTokenizer(bufR.readLine(), " ");

        int A = Integer.parseInt(read.nextToken());
        int B = Integer.parseInt(read.nextToken());

        String result = "==";
        if (A > B)
            result = ">";
        else if (A < B)
            result = "<";

        bufW.write(result);
        bufW.flush(); // 출력 버퍼를 비우기

        bufR.close();
        bufW.close();
    }
}