class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        // 승패 기록 : 1 이김 -1 짐 : [4, 3] -> [4][3] = 1 ; [3][4] = -1;
        int[][] note = new int[n + 1][n + 1];
        
        for (int[] res : results) {
            note[res[0]][res[1]] = 1;
            note[res[1]][res[0]] = -1;
        }
        
        // 연관된 경기기록까지 체크
        for (int i = 1; i <= n; i++) {
            int win = dfs(i, 1, new boolean[n + 1], note, n);
            int loss = dfs(i, -1, new boolean[n + 1], note, n);
            // n-1번의 기록이 있으면 확실하게 알수있음
            if (win + loss == n - 1) {
                answer++;
            }
        }
        return answer;
    }
    
    private int dfs(int now, int target, boolean[] visited, int[][] note, int n) {
        int count = 0;
        visited[now] = true;
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && note[now][i] == target) {
                count += 1 + dfs(i, target, visited, note, n);
            }
        }
        return count;
    }
}