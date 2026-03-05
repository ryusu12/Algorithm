import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //위 x 오 x x x 왼 x
        List<List<Integer>> gears = new ArrayList<>();
        for (int i = 0; i < 4; i++) gears.add(getGear(br));

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(token.nextToken()) - 1;

            // 방향 구하기
            int[] turns = new int[4];
            turns[num] = Integer.parseInt(token.nextToken());

            // 서로 극이 다르면 - 반대방향
            // 오른쪽
            for (int j = num; j < 3; j++) {
                if (!gears.get(j).get(2).equals(gears.get(j + 1).get(6))) {
                    turns[j + 1] = -turns[j];
                } else break;
            }
            //왼쪽
            for (int j = num; j > 0; j--) {
                if (!gears.get(j).get(6).equals(gears.get(j - 1).get(2))) {
                    turns[j - 1] = -turns[j];
                } else break;
            }

            // 회전
            for (int j = 0; j < 4; j++) {
                if (turns[j] == -1) turnL(gears.get(j));
                else if (turns[j] == 1) turnR(gears.get(j));
            }
        }

        // 계산
        int answer = 0;
        int score = 1;
        for (int i = 0; i < 4; i++) {
            if (gears.get(i).get(0) == 1) answer += score;
            score *= 2;
        }
        System.out.println(answer);
    }

    private static void turnL(List<Integer> gear) {
        gear.add(gear.remove(0));
    }

    private static void turnR(List<Integer> gear) {
        gear.add(0, gear.remove(7));
    }

    private static List<Integer> getGear(BufferedReader br) throws Exception {
        List<Integer> gear = new ArrayList<>();
        String line = br.readLine();
        for (int i = 0; i < 8; i++) {
            gear.add(line.charAt(i) - '0');
        }
        return gear;
    }
}
