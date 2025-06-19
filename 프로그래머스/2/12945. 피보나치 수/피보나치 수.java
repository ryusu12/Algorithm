class Solution {
    public int solution(int n) {
        int last1 = 1;
        int last2 = 1;
        for (int i = 3; i <= n; i++) {
            int now = last1 + last2;
            last2 = last1 % 1234567;
            last1 = now % 1234567;
        }
        return last1;
    }
}