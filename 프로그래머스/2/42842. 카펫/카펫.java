// brown = xy - yellow
// yellow = (x-2) * (y-2)
// brown = 2y+ 2x - 4

// xy = brown + yellow
// x+y = (brown+4)/2

// x = (brown + yellow + 1) / (brown+4)/2
// y = (brown+4)/2 - x

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        double sum = (double)(brown+4) / 2;
        double xy = brown + yellow;
        
        int y = 1;
        for (y = 1; y < 5000; y++) {
            if (sum == (xy / y + y)) {
                break;
            }
        }
        int x = (int)sum - y;

        answer[0] = x;
        answer[1] = y;
        return answer;
    }
}