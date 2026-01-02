import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a,b) -> a[1] - b[1]);
        int camera = routes[0][1];
        int answer = 1;
        
        for (int i = 1; i < routes.length; i++) {
            // 1끝 >= 2시작 이면 : 교집합
            if (camera >= routes[i][0]) continue;
            // 아니면 새로 설치
            else {
                camera = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}