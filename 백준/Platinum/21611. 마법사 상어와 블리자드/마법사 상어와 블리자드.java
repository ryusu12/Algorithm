import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static List<int[]> listYX = new ArrayList<>();
    static List<Integer> listNum = new ArrayList<>();
    static int n;

    static int sx, sy;

    // 나선 : 좌하우상
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    // 지시 방향 : 상하좌우
    static int[] ddx = {0, 0, -1, 1};
    static int[] ddy = {-1, 1, 0, 0};

    static int[] arr = new int[4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        sx = sy = n / 2;
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 벽을따라 좌표를 따로 만듬
        initList();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            // 마법 시전

            // map -> list
            mapToList();
            // d 방향으로 s이하의 거리의 칸을 다 비움
            magic(d, s);

            // 파괴 가능할때까지 계속 반복함
            while (true) {
                if (!destroy()) break;
            }

            // 새로 맵 갱신
            getNewMap();
            listToMap();
        }

        // int[3] 폭발한 구슬 개수
        int answer = 0;
        for (int i = 1; i < arr.length; i++) {
            answer += i * arr[i];
        }
        System.out.println(answer);
    }

    private static void listToMap() {
        for (int i = 0; i < n; i++) Arrays.fill(map[i], 0);

        for (int i = 0; i < listNum.size(); i++) {
            int[] now = listYX.get(i);
            map[now[0]][now[1]] = listNum.get(i);
        }
    }

    private static void getNewMap() {
        if (listNum.isEmpty()) return;

        List<Integer> newListNum = new ArrayList<>();

        // 벽따라 연속하는 숫자 뭉치 파악 : 첫 숫자 B - B와 같은 숫자가 연속해서 몇개 있는지 A
        for (int i = 0; i < listNum.size();) {
            int now = listNum.get(i);
            int count = 1;
            for (int j = i + 1; j < listNum.size(); j++) {
                if (listNum.get(j) == now) {
                    count++;
                } else {
                    break;
                }
            }

            // 새 맵에 A, B 로 넣음
            newListNum.add(count);
            newListNum.add(now);
            if (newListNum.size() >= n * n) break;
            i += count;
        }
        if (newListNum.size() > n * n - 1) {
            listNum = new ArrayList<>(newListNum.subList(0, n * n - 1));
        } else {
            listNum = newListNum;
        }
    }

    private static boolean destroy() {
        // 벽따라 숫자 4개이상 연속되면 모두 파괴됨
        if (listNum.isEmpty()) return false;
        boolean flag = false;

        List<Integer> newListNum = new ArrayList<>();

        for (int i = 0; i < listNum.size();) {
            int now = listNum.get(i);
            int count = 1;
            for (int j = i + 1; j < listNum.size(); j++) {
                if (listNum.get(j) == now) {
                    count++;
                } else {
                    break;
                }
            }

            if (count >= 4) {
                arr[now] += count; // 폭발한 구슬 정보 갱신
                flag = true;
            } else {
                // 4개 미만인것만 따로 모음
                for (int j = 0; j < count; j++) {
                    newListNum.add(now);
                }
            }
            i += count;
        }
        listNum = newListNum;
        return flag;
    }

    private static void magic(int d, int s) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= s; i++) {
            int nx = sx + ddx[d] * i;
            int ny = sy + ddy[d] * i;

            map[ny][nx] = 0;

            // 위치 찾기 - 리스트 갱신
            for (int j = 0; j < listYX.size(); j++) {
                int[] now = listYX.get(j);
                if (nx == now[1] && ny == now[0]) {
                    list.add(j);
                    break;
                }
            }
        }
        list.sort((a, b) -> b.compareTo(a));
        for (int i : list) {
            if (i >= listNum.size()) continue;
            listNum.remove(i);
        }
    }

    private static void mapToList() {
        listNum.clear();
        for (int[] now : listYX) {
            if (map[now[0]][now[1]] == 0) continue;
            listNum.add(map[now[0]][now[1]]);
        }
    }

    private static void initList() {
        int move = 0;
        int len = 1;
        while (true) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < len; j++) {
                    int nx = sx + dx[move];
                    int ny = sy + dy[move];

                    if (!inMap(ny, nx)) return;
                    listYX.add(new int[]{ny, nx});
                }
                move = (move + 1) % 4;
            }
            len++;
        }
    }

    private static boolean inMap(int y, int x) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}
