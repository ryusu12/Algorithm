class Solution {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        int sum = 0;
        int idx = 0;
        dfs(numbers, target, sum, idx);

        return answer;
    }

    private void dfs(int[] numbers,  int target, int sum, int idx) {
        if (idx == numbers.length) {
            if (sum == target) answer++;
            return;
        }
        int deleteSum = sum - numbers[idx];
        dfs(numbers, target, deleteSum, idx + 1);
        int addSum = sum + numbers[idx];
        dfs(numbers, target, addSum, idx + 1);
    }
}