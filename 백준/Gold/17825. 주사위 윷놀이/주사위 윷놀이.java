import java.io.*;
import java.util.*;

public class Main {

    // 게임판 : 한줄씩 끊어서
    static int[][] map = {
            {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40},
            {10, 13, 16, 19, 25},
            {20, 22, 24, 25},
            {30, 28, 27, 26, 25},
            {25, 30, 35, 40}
    };
    static int maxScore = 0;
    static int[] dice = new int[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 주사위 수 10개 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        // 경로 번호, 인덱스, 도착여부
        int[][] piece = new int[4][3];

        playGame(piece, 0, 0);

        System.out.println(maxScore);
    }

    private static void playGame(int[][] piece, int score, int round) {
        // 게임 10턴
        if (round >= 10) {
            maxScore = Math.max(maxScore, score);
            return;
        }

        // 도착하지 않은 말을 이동
        for (int i = 0; i < 4; i++) {
            if (piece[i][2] == 1) continue; // 도착한것 패스
            int r = piece[i][0];
            int c = piece[i][1];

            // 지름길 체크
            int nr = r, nc = c;
            if (nr == 0) {
                if (nc == 5) {
                    nr = 1;
                    nc = 0;
                } else if (nc == 10) {
                    nr = 2;
                    nc = 0;
                } else if (nc == 15) {
                    nr = 3;
                    nc = 0;
                }
            }

            // 5면체 주사위 돌림
            int dis = dice[round];
            boolean finished = false;

            // 이동
            for (int d = 0; d < dis; d++) {
                nc++;

                // 경로의 끝을 넘을때
                if (nc >= map[nr].length) {
                    if (nr >= 1 && nr <= 3) {
                        nr = 4;
                        nc = 1;
                    } else if (nr == 4 || nr == 0) {
                        finished = true;
                        break;
                    }
                }
                // 끝에 멈출때
                if (map[nr][nc] == 25) {
                    nr = 4;
                    nc = 0;
                } else if (map[nr][nc] == 40) {
                    nr = 0;
                    nc = 20;
                }
            }

            if (finished) {
                piece[i][2] = 1;
                playGame(piece, score, round + 1);
                piece[i][2] = 0; // 복구
            } else if (!exist(piece, nr, nc, i)) {
                int nextScore = map[nr][nc];
                piece[i][0] = nr;
                piece[i][1] = nc;
                playGame(piece, score + nextScore, round + 1);
                // 복구
                piece[i][0] = r;
                piece[i][1] = c;
            }
        }
    }

    private static boolean exist(int[][] piece, int nr, int nc, int idx) {
        for (int i = 0; i < 4; i++) {
            // 현재거나 끝났거나
            if (i == idx || piece[i][2] == 1) continue;
            if (piece[i][0] == nr && piece[i][1] == nc) return true;
        }
        return false;
    }
}
