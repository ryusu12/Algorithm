class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        int idx = 0;

        long leftRow = (left + 1) / n + 1;
        long rightRow = (right + 1) / n + 1;
        long leftCol = (left + 1) % n;
        long rightCol = (right + 1) % n;

        if ((left + 1) % n == 0) {
            leftRow = (left + 1) / n;
            leftCol = n;
        }
        if ((right + 1) % n == 0) {
            rightRow = (right + 1) / n;
            rightCol = n;
        }
        
        for (long row = leftRow; row <= rightRow; row++) {
            long start = 1;
            long end = n;
            if (row == leftRow) start = leftCol;
            if (row == rightRow) end = rightCol;
            for (long col = start; col <= end; col++) {
                answer[idx++] = (int) Math.max(col, row);
            }

        }
        return answer;
    }
}