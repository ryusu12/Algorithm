class Solution {
    public int solution(int[][] triangle) {
        // 누적된 삼각형
        int[][] sumTri = new int[triangle.length][triangle.length];
        sumTri[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                // 20 = 20 + 10 / 21 = Max<21 + 10, 21 + 11> / 22 = 22 + 11
                if (j == 0) {
                    sumTri[i][j] = triangle[i][j] + sumTri[i-1][j];
                }
                else if (j == triangle[i].length - 1) {
                    sumTri[i][j] = triangle[i][j] + sumTri[i-1][j-1];
                }
                else {
                    sumTri[i][j] = Math.max(triangle[i][j] + sumTri[i-1][j-1], triangle[i][j] + sumTri[i-1][j]);
                }
            }
        }
        
        // 끝까지 도달 : 최대값 확인
        int answer = 0;
        for (int last : sumTri[triangle.length - 1]) {
            answer = Math.max(answer, last);
        }
        return answer;
    }
}