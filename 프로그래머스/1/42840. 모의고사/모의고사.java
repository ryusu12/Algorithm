import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 각자 찍는 방식 - 배열
        int[] arr1 = new int[] {1, 2, 3, 4, 5};
        int[] arr2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int idx1 = 0;
        int idx2 = 0;
        int idx3 = 0;
        
        // 맞춘 값 : correct 배열 [1, 2, 3]
        int[] correct = new int[] {0, 0, 0};
        
        for (int i = 0; i < answers.length; i++) {
            if (idx1 >= arr1.length) idx1 = 0;
            if (idx2 >= arr2.length) idx2 = 0;
            if (idx3 >= arr3.length) idx3 = 0;
            if (answers[i] == arr1[idx1++]) correct[0]++;
            if (answers[i] == arr2[idx2++]) correct[1]++;
            if (answers[i] == arr3[idx3++]) correct[2]++;
        }
        
        // 최대값 구하기
        int max = 0;
        for (int i = 0; i < correct.length; i++) {
            max = Math.max(max, correct[i]);
        }
        // 최대값인 사람 구하기 - 최대값이면 인덱스 리턴
        int count = 0;
        for (int i = 0; i < correct.length; i++) {
            if (max == correct[i]) count++;
        }
        int[] answer = new int[count];
        int idx = 0;
        for (int i = 0; i < correct.length; i++) {
            if (max == correct[i]) answer[idx++] = i + 1;
        }
        return answer;
    }
}