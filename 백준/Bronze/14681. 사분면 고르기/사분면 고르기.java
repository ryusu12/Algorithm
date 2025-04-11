import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(bufR.readLine());
        int y = Integer.parseInt(bufR.readLine());
        int result = 4;
        if (x > 0 & y > 0) result = 1;
        else if (x < 0 & y > 0) result = 2;
        else if (x < 0 & y < 0) result = 3;

        bufW.write(String.valueOf(result));
        bufW.flush();
        bufR.close();
        bufW.close();
    }
}