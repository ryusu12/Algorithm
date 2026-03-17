import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, k;

    // 이동방향 : 우좌상하
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // nn 체스판 : 판정보만 담음
        int[][] map = new int[n][n];
        // [행][열][체스번호] => 이동하는 말의 좌표와 같은 좌표면 같이 갱신
        List<Integer>[][] chessMap = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                chessMap[i][j] = new ArrayList<>();
            }
        }

        // 체스 기록
        // 체스 말 K개 : 1~K번 : 순서대로 이동 {행,열,이동방향} : 행열 1~n / 방향 1~4 : 우좌상하
        int[][] chess = new int[k][3];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) - 1;

            chess[i][0] = y;
            chess[i][1] = x;
            chess[i][2] = dir;

            chessMap[y][x].add(i);
        }

        // 이동
        // 말이 4개 이상 얹여있으면 종료
        for (int turn = 1; turn <= 1000; turn++) {
            for (int i = 0; i < k; i++) {
                int y = chess[i][0];
                int x = chess[i][1];
                int dir = chess[i][2];

                // 다음 이동 위치
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 다음칸에 따라 이동이 다름
                // 파랑 2 & 체스판 넘어갈때 : 지금말의 이동방향 반대로 바꾸고 (파란색 아닐때)한칸 이동
                if (!inMap(ny, nx) || map[ny][nx] == 2) {
                    // 이동방향 반전
                    dir = (dir % 2 == 0) ? dir + 1 : dir - 1;
                    chess[i][2] = dir;

                    nx = x + dx[dir];
                    ny = y + dy[dir];
                    // 여전히 이동 못하면 그냥 넘김
                    if (!inMap(ny, nx) || map[ny][nx] == 2) continue;
                }

                // 이동할 말 뭉치 따로 빼두기
                int startIdx = chessMap[y][x].indexOf(i);
                List<Integer> moveList = new ArrayList<>();
                for (int j = startIdx; j < chessMap[y][x].size(); j++) {
                    moveList.add(chessMap[y][x].get(j));
                }
                for (int j = chessMap[y][x].size() - 1; j >= startIdx; j--) {
                    chessMap[y][x].remove(j);
                }

                // 빨강 1 : 다음칸 말 뭉치에 지금말뭉치 순서 반전해서 올림
                if (map[ny][nx] == 1) {
                    Collections.reverse(moveList);
                }

                // 말 뭉치 이동시키기
                for (int movedId : moveList) {
                    chessMap[ny][nx].add(movedId);
                    chess[movedId][0] = ny;
                    chess[movedId][1] = nx;
                }

                if (chessMap[ny][nx].size() >= 4) {
                    System.out.println(turn);
                    return;
                }
            }
        }
        System.out.println(-1);
    }

    private static boolean inMap(int y, int x) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}
