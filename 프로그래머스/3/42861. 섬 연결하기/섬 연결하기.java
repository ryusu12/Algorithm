import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    boolean[] visited;
    int count = 0;
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        visited = new boolean[n];
        visited[0] = true;
        
        fun(costs[0][0], 0, n - 1, costs);
        
        return answer;
    }
    
    private void fun (int land, int nowCost, int count, int[][] costs) {
        // 선택표시가 n-1개이면 해당 경로 탐색완료 - 최소값만 저장
        if (count == 0) {
            answer = Math.min(answer, nowCost);
            return;
        }
        
        // 현재 경로가 이미 답보다 크면 즉시 종료
        if (nowCost >= answer) return;
        
        // costs[i][0] 을 기준으로 안간곳중 갈수있는곳 다 확인
        for (int i = 0; i < costs.length; i++) {
            // 한쪽은 간곳 한쪽은 안간곳
            boolean check1 = visited[costs[i][0]] && !visited[costs[i][1]];
            boolean check2 = !visited[costs[i][0]] && visited[costs[i][1]];
            
            if (check1 || check2) {
                visited[costs[i][0]] = true;
                visited[costs[i][1]] = true;
                fun(costs[i][1], nowCost + costs[i][2], count - 1, costs);
            }
        }
    }
}