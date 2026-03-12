import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int len1 = str1.length();
        int len2 = str2.length();
        int[][] count = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 같으면 둘다 뒤인거 + 1;
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    count[i][j] = count[i-1][j-1] + 1;
                } else {
                    // 다르면 서로 하나 뒤인거 중에 큰값으로 갱신
                    count[i][j] = Math.max(count[i-1][j], count[i][j-1]);
                }
            }
        }

        System.out.print(count[len1][len2]);
    }
}
