import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int length = 0;
        for (int num : arr) {
            if ((num % divisor) == 0) {
                length++;
            }
        }
        if(length == 0) {
            return new int[]{-1};
        }
        int[] answer = new int[length];

        int idx = 0;
        for (int num : arr) {
            if (num % divisor == 0) {
                answer[idx++] = num;
            }
        }
        Arrays.sort(answer);
        return answer;
    }
}