class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        // 숙련도 최소 : 1, 최대 : 100000
        int left = 1;
        int rigth = 100000;
        int answer = rigth;
        
        while (left <= rigth) {
            int level = (left + rigth) / 2;
            
            long now = 0;
            for (int i = 0; i < diffs.length; i++) {
                if (diffs[i] <= level) {
                    now += times[i];
                } else {
                    now += (long) (times[i] + times[i-1]) * (diffs[i] - level) + times[i];
                }
                if (now > limit) break;
            }

            if (now <= limit) {
                rigth = level - 1;
                answer = Math.min(answer, level);
            } else {
                left = level + 1;
            }
        }
        
        return answer;
    }
}