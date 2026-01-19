import java.util.*;

class Solution {
    
    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    
    public int solution(int[] arrows) {
        int answer = 0;
        
        // x, y
        Set<String> map = new HashSet<>();
        // 이전좌표, 이동좌표
        Set<String> route = new HashSet<>();
        
        int x = 0;
        int y = 0;
        String last = "0,0";
        map.add(last);
        
        // 선 좌표 표시
        for (int i = 0; i < arrows.length; i++) {
            for (int j = 0; j < 2; j++) {
                int nx = x + dx[arrows[i]];
                int ny = y + dy[arrows[i]];
                String now = nx + "," + ny;

                String move1 = last + now;
                String move2 = now + last;

                // 이미 체크한 곳을 또 들리면 방 있는 것 // 같은 방향으로 움직였는지 확인
                if (map.contains(now) && !route.contains(move1) && !route.contains(move2)) {
                    answer++;
                }
                map.add(now);
                route.add(move1);
                route.add(move2);
                
                // 좌표 이동
                x = nx;
                y = ny;
                last = now;
            }
        }
        return answer;
    }
}