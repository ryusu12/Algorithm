class Solution {
    public int solution(String arr[]) {
        // i~j 번까지 계산한 결과 : int[i][j]{최대,최소}
        int[][][] map = new int[arr.length][arr.length][2];
        
        // 초기화
        for (int i = 0; i < arr.length; i += 2) {
            for (int j = 0; j < arr.length; j += 2) {
                if (i == j) {
                    map[i][j][1] = Integer.parseInt(arr[i]);
                    map[i][j][0] = Integer.parseInt(arr[i]);
                }
                else {
                    map[i][j][1] = Integer.MAX_VALUE;
                    map[i][j][0] = Integer.MIN_VALUE;
                }
                
            }
        }
        
        // 묶음 길이
        for (int len = 2; len < arr.length; len += 2) {
            for (int i = 0; i < arr.length - len; i += 2) {
                int j = i + len;
                // 연산자 위치
                for (int k = i+1; k < j; k += 2) {
                    String op = arr[k];
                    
                    if (op.equals("+")) {
                        // 더하기 최대 = 최대 + 최대 / 최소 = 최소 + 최소
                        map[i][j][0] = Math.max(map[i][j][0], map[i][k-1][0] + map[k+1][j][0]);
                        map[i][j][1] = Math.min(map[i][j][1], map[i][k-1][1] + map[k+1][j][1]);
                    } else {
                        // 빼기 최대 = 최대 - 최소 / 최소 = 최소 - 최대
                        map[i][j][0] = Math.max(map[i][j][0], map[i][k-1][0] - map[k+1][j][1]);
                        map[i][j][1] = Math.min(map[i][j][1], map[i][k-1][1] - map[k+1][j][0]);
                    }
                }
            }
        }
        
        return map[0][arr.length - 1][0];
    }
}