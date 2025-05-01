import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        while (true) {
            String walk = br.readLine();
            if (walk == null) break;
            if (walk.equals("gum gum for jay jay")) count++;
        }
        System.out.println(count);
    }
}