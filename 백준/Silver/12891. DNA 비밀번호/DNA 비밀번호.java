import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int count = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        // 체크 배열
        st = new StringTokenizer(br.readLine(), " ");
        int[] check = new int[4];
        for (int i = 0; i < 4; i++) check[i] = Integer.parseInt(st.nextToken());

        // 초기 현재상태 배열
        int[] arr = new int[4];
        for (int i = 0; i < P; i++) {
            arr[getIndex(str.charAt(i))]++;
        }

        // 검사
        if (getCheck(check, arr)) count++;

        // 이동
        for (int i = 1; i + P-1 < S; i++) {
            int first = i-1;
            int end = i + P-1;
            arr[getIndex(str.charAt(first))]--;
            arr[getIndex(str.charAt(end))]++;
            if (getCheck(check, arr)) count++;
        }
        System.out.println(count);
    }

    private static int getIndex(char c) {
        switch (c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
            default: return -1;
        }
    }

    private static boolean getCheck(int[] check, int[] arr) {
        for (int k = 0; k < 4; k++) {
            if (check[k] > arr[k]) return false;
        }
        return true;
    }
}