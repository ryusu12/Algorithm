import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> line = new ArrayList<>(); // 내구도 정보
        List<Boolean> robot = new ArrayList<>(N);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) line.add(Integer.parseInt(st.nextToken()));
        for (int i = 0; i < N * 2; i++) robot.add(false);

        int step = 0;
        while (true) {
            step++;

            // 회전
            line.add(0, line.remove(line.size() - 1));
            robot.remove(N-1);
            robot.add(0, false);
            robot.set(N-1, false); // 내리는 위치 : N-1 - 도달하면 내리기

            // 이동 : 이동하는 칸에 로봇 없거나, 이동하는 칸의 내구도 1 이상
            for (int i = N - 2; i >= 0; i--) {
                if (robot.get(i) && !robot.get(i+1) && line.get(i+1) > 0) {
                    robot.set(i+1, true);
                    robot.set(i, false);
                    line.set(i+1, line.get(i+1) - 1); // 내구도 감소
                    // 내리는 위치 : N-1 - 도달하면 내리기
                    if (i + 1 == N-1) robot.set(i+1, false);
                }
            }

            // 올리는 위치 : 0 - 칸 내구도가 0이 아닐때 올림
            if (!robot.get(0) && line.get(0) > 0) {
                robot.set(0, true);
                line.set(0, line.get(0) - 1); // 내구도 감소
            }

            // 내구도 0인거 >= K : 종료
            int zero = 0;
            for (int i = 0; i < line.size(); i++) {
                if (line.get(i) == 0) zero++;
                if (zero >= K) break;
            }
            if (zero >= K) break;
        }
        System.out.print(step);
    }
}
