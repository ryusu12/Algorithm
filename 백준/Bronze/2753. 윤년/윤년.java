import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));

        int year = Integer.parseInt(bufR.readLine());
        int result = 0;

        if (((year % 4 == 0) & (year % 100 != 0)) || (year % 400 == 0)) {
            result = 1;
        }

        bufW.write(String.valueOf(result));
        bufW.flush();
        bufR.close();
        bufW.close();
    }
}