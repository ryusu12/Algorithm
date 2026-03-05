import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 회의시간
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(token.nextToken());
            arr[i][1] = Integer.parseInt(token.nextToken());
        }

        // 최대한 많은 회의; 빨리 끝나는 회의를 선택
        // 끝나는시간 arr[][1]을 기준으로 정렬 -> arr[][0]을 기준으로 정렬
        Arrays.sort(arr, (a,b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int endTime = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (endTime <= arr[i][0]) {
                endTime = arr[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
