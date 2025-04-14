import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufRead = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufWrite = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufRead.readLine());
        for (int i = 1; i <= N; i++) {
            bufWrite.write(i + "\n");
        }
        bufWrite.flush();

        bufRead.close();
        bufWrite.close();
    }
}