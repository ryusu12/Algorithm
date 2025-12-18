class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        // 현재 prices <= 뒷부분 prices 최소값 이면 떨어지지 않음
        // 현재 prices > 뒷부분 prices 최소값 ? 최소값 기준까지 떨어짐
        for (int i = 0; i < prices.length; i++) {
            int idx = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if(prices[i] > prices[j]) {
                    idx = j;
                    break;
                }
            }
            if (idx > 0) answer[i] = idx - i;
            else answer[i] = prices.length - 1 - i;
        }
        return answer;
    }
}