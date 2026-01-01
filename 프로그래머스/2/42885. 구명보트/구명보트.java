import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        // 젤 큰거 + 제일 작은것끼리 모아서 비교
        Arrays.sort(people);
        int minI = 0;
        
        for (int i = people.length - 1; i >= 0 && i >= minI; i--) {
            int sum = people[i];
            if (sum + people[minI] <= limit && i >= minI) {
                minI++;
            }
            answer++;
        }
        return answer;
    }
}