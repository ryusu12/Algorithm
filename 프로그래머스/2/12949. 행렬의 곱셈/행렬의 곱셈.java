class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int len1 = arr1.length;
        int len2 = arr1[0].length;
        int len3 = arr2[0].length;
        int[][] answer = new int[len1][len3];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len3; j++) {
                for (int k = 0; k < len2; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}