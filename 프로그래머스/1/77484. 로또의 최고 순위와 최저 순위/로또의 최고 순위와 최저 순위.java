import java.util.*;

class Solution {
    public int ranking(int num) {
        return switch (num) {
            case 6 -> 1;
            case 5 -> 2;
            case 4 -> 3;
            case 3 -> 4;
            case 2 -> 5;
            default -> 6;
        };
    }
    
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero = 0;
        int result = 0;

        for (int lotto : lottos) {
            if (lotto == 0) zero++;
            for (int winNum : win_nums) {
                if (winNum == lotto) result++;
            }
        }
        answer[0] = ranking(result + zero);
        answer[1] = ranking(result);

        return answer;
    }
}