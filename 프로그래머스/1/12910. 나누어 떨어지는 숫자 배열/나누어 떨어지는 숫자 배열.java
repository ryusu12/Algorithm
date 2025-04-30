import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(num -> (num % divisor) == 0).sorted().toArray();
        if (answer.length == 0) {
            int[] empty = {-1};
            return empty;
        }
        return answer;
    }
}