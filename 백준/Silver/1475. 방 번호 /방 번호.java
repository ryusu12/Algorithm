import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 0~9 번호의 int 배열 : 9 안씀 6으로 갱신함
        int[] arr = new int[9];

        // 방번호 N
        String doorNum = br.readLine();

        // for N 한자리씩 돌면서
        for (char num : doorNum.toCharArray()) {
            // 필요한 번호 체크 : arr[charAt(i)]++
            // if 필요번호 = 9 면 6++;
            if (num == '9') {
                arr[6]++;
            } else {
                arr[num - '0']++;
            }
        }

        // 확인하기
        int count = 0;
        for (int i = 0; i < 9; i++) {
            // 필요한번호 for 문 돌면서 최대값 확인 - 8까지 확인
            if (i == 6) {
                count = Math.max(count, (arr[i] + 1) / 2);
            } else {
                count = Math.max(count, arr[i]);
            }
        }

        System.out.println(count);
    }
}
