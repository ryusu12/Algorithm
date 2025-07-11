import java.util.*;

class Solution {
    int answer = 0;

    public int solution(int k, int[][] dungeons) {
        // 완전 탐색 - 백트래킹
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0, visited);
        return answer;
    }

    private void dfs(int k, int[][] dungeons, int cnt, boolean[] visited) {
        // 최대 방문 던전 수
        answer = Math.max(answer, cnt);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, cnt + 1, visited);
                visited[i] = false;
            }
        }
    }

}