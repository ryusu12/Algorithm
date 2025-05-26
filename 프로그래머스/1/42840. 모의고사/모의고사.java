import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] counts = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == arr1[i % arr1.length]) counts[0]++;
            if (answers[i] == arr2[i % arr2.length]) counts[1]++;
            if (answers[i] == arr3[i % arr3.length]) counts[2]++;
        }
        int max = Math.max(counts[0], Math.max(counts[1], counts[2]));
        
        int size = 0;
        for (int c : counts) {
            if (c == max) size++;
        }

        int[] result = new int[size];
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            if (max == counts[i]) result[idx++] = i + 1;
        }
        return result;
    }
}