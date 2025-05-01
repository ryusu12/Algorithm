import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length <= 1) {
            return new int[]{-1};
        }

        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        int[] answer = new int[arr.length - 1];
        int i = 0;
        for (int num : arr) {
            if (num != min) {
                answer[i++] = num;
            }
        }
        return answer;
    }
}