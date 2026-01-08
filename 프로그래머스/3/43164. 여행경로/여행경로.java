import java.util.*;

class Solution {
    boolean[] visited;
    ArrayList<String> route;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        route = new ArrayList<>();
        
        // 티켓[1]을 기준으로 정렬
        Arrays.sort(tickets, (a,b) -> a[1].compareTo(b[1]));
        route.add("ICN");
        dfs("ICN", tickets, 0);
        
        return route.toArray(String[]::new);
    }
    
    private boolean dfs(String now, String[][] tickets, int count) {
        // 탐색 다 하면 종료
        if (count == tickets.length) {
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && now.equals(tickets[i][0])) {
                route.add(tickets[i][1]);
                visited[i] = true;
                // 성공하면 더이상 백트래킹 안함
                if (dfs(tickets[i][1], tickets, count + 1)) {
                    return true;
                };
                visited[i] = false;
                route.remove(route.size() - 1);
            }
        }
        return false;
    }
}