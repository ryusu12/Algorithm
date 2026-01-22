import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        // 최단 경로로 이동하는 좌표 표시
        List<Queue<int[]>> route = new ArrayList<>();
        
        for (int i = 0; i < routes.length; i++) {
            Queue<int[]> path = new LinkedList<>();
            path.offer(new int[]{points[routes[i][0] - 1][0], points[routes[i][0] - 1][1]});
            // 출발지/목적지 좌표
            for (int j = 0; j < routes[i].length - 1; j++) {
                int[] start = points[routes[i][j] - 1];
                int[] end = points[routes[i][j+1] - 1];
                move(path, start, end);
            }
            route.add(path);
            
            
        }
        
        // 중접되는 수 확인 {좌표 String x,y,카운트} 
        while (true) {
            // 시간이 흐를떄마다 매순간 맵에 넣음
            Map<String, Integer> count = new HashMap<>();
            
            for (int i = 0; i < routes.length; i++) {
                if (!route.get(i).isEmpty()) {
                    int[] now = route.get(i).poll();
                    String rc = now[0] + "," + now[1];
                    count.put(rc, count.getOrDefault(rc, 0) + 1);
                }
            }
            
            // 맵에 없을때 나가기
            if (count.size() == 0) {
                break;
            }
            
            for (int c : count.values()) {
                if (c >= 2) answer++;
            }
        }
        
        return answer;
    }
    private void move(Queue<int[]> path, int[] start, int[] end) {
        
        int r = start[0];
        int c = start[1];
        
        // r 좌표가 변하는 이동을 c 좌표가 변하는 이동보다 먼저 합니다.
        while (r != end[0]) {
            if (r < end[0]) {
                r++;
            } else {
                r--;
            }
            path.offer(new int[]{r, c});
        }
        
        while (c != end[1]) {
            if (c < end[1]) {
                c++;
            } else {
                c--;
            }
            path.offer(new int[]{r, c});
        }
    }
}