class Solution {
    public long solution(int n) {
        long last1 = 1;
        long last2 = 1; 
        for (int i = 2; i <= n; i++) {
            long now = (last1 + last2) % 1234567;
            last2 = last1;
            last1 = now;
        }
        return last1;
    }
}