import java.io.*;
import java.util.*;

public class Main {
    static int n, m, d;
    static int[] arrow = new int[3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        // 적위치 List enemy [[y,x], [y,x], ..]
        List<int[]> enemy = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num  = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    enemy.add(new int[]{i, j});
                }
            }

        }

        int max = 0;
        // 궁수3 -> 성칸에 1명 배치가능 : y=n+1, x 지정
        for (int i = 0; i < m; i++) {
            arrow[0] = i;
            for (int j = i+1; j < m; j++) {
                arrow[1] = j;
                for (int k = j+1; k < m; k++) {
                    arrow[2] = k;
                    // 궁수 공격
                    max = Math.max(max, game(enemy));
                }
            }
        }
        System.out.println(max); // 제거할수있는 적의 최대값
    }

    private static int game(List<int[]> baseEmy) {
        int hit = 0;

        List<int[]> enemy = new ArrayList<>();
        for (int[] e : baseEmy) {
            enemy.add(e.clone());
        }

        while (!enemy.isEmpty()) {
            // 공격할 수 있는 적 선정 : 같은 적 선정 가능 (가장 가깝고 왼쪽)
            Set<int[]> attack = new HashSet<>();

            for (int ax : arrow) {
                int minLen = n+1;
                int minx = m+1;
                int[] target = null;

                for (int[] e : enemy) {
                    int dis = Math.abs(e[0] - n) + Math.abs(e[1] - ax);

                    if ((dis <= d) && ((dis < minLen) || (dis == minLen && e[1] < minx))) {
                        minLen = dis; // 현재 최소길이 갱신
                        minx = e[1]; // 최소 좌표 갱신
                        target = e; //좌표등록
                    }
                }
                if (target != null) {
                    attack.add(target);
                }
            }

            // 동시공격 : 공격받은적은 게임에서 제외
            for (int[] e : attack) {
                enemy.remove(e);
                hit++; // 공격한 수 체크하기
            }

            // 적 이동 : 아래로 한칸 이동, 성으로 이동: 게임제외
            List<int[]> next = new ArrayList<>();
            for (int[] e : enemy) {
                e[0]++;
                if (e[0] < n) next.add(e);
            }
            enemy = next;
        }
        return hit;
    }
}
