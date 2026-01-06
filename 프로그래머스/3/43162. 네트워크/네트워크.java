import java.util.*;

class Solution {
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            // 새 간선이면 ? 네트워크 개수 ++, 계속 이어지는지 확인
            if (!visited[i]) {
                answer++;
                fun(i, n, computers);
            }
        }
        return answer;
    }
    
    private void fun(int i, int n, int[][] computers) {
        visited[i] = true;
        
        for (int j = 0; j < n; j++) {
            // ii경우 제외, 안거쳤고, 이어지는지 확인
            if ((i != j) && (computers[i][j] == 1) && (!visited[j])) {
                fun(j, n, computers);
            }
        }
    }
}