class Solution {
    
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }
    
    private void dfs(int now, int idx, int[] numbers, int target) {
        if (idx == numbers.length) {
            if (now == target) answer++;
            return;
        }
        
        dfs(now + numbers[idx], idx + 1, numbers, target);
        dfs(now - numbers[idx], idx + 1, numbers, target);
    }
}