class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
                      
        // 갈 수 없는곳 체크 : 가능 = 0; 불가능 = -1
        int[][] map = new int[n][m];
        for (int[] p : puddles) {
            map[p[1] - 1][p[0] - 1] = -1;
        }
        
        // 맵에 거리 체크
        map[0][0] = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 갈 수 있는지 확인
                // 시작, 물웅덩이 패스
                if (map[i][j] == -1) {
                    map[i][j] = 0;
                    continue;
                }
                
                // 이동 거리 체크 : 두방법 누적
                if (j-1 >= 0) {
                    map[i][j] = (map[i][j-1] + map[i][j]) % 1000000007;
                }
                if (i-1 >= 0) {
                    map[i][j] = (map[i-1][j] + map[i][j]) % 1000000007;
                }
            }
        } 
        return map[n-1][m-1];
    }
}