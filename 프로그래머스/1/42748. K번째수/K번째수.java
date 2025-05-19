import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int c = 0; c < commands.length; c++) {
            int i = commands[c][0] - 1;
            int j = commands[c][1];
            int k = commands[c][2] - 1;
            int[] arr = Arrays.copyOfRange(array, i, j);
            Arrays.sort(arr);
            answer[c] = arr[k];
        }
        return answer;
    }
}