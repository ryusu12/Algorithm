class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        double sum = (double) (brown + 4) / 2;
        double sum2 = brown + yellow;
        int x;
        for (x = 1; x < 5000; x++) {
            if ( sum == (x + sum2 / x)) break;
        }

        int y = (int) (sum2 / x);
        answer[0] = Math.max(x, y);
        answer[1] = Math.min(x, y);
        return answer;
    }
}