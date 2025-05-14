class Solution {
    public int solution(int[][] sizes) {
        int higth = 0;
        int width = 0;
        for (int i = 0; i < sizes.length; i++) {
            higth = Math.max(higth, Math.max(sizes[i][0], sizes[i][1]));
            width = Math.max(width, Math.min(sizes[i][0], sizes[i][1]));
        }
        return higth * width;
    }
}