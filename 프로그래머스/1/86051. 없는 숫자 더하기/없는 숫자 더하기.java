class Solution {
    public int solution(int[] numbers) {
        int[] num = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int answer = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j <= 9; j++) {
                if (numbers[i] == j) {
                    num[j] = 1;
                    break;
                }
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (num[i] == 0) {
                answer += i;
            }
        }
        return answer;
    }
}