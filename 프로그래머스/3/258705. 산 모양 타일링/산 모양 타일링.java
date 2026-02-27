class Solution {
    public int solution(int n, int[] tops) {
        int MOD = 10007;
        int[] left = new int[n];
        int[] rigth = new int[n];

        if (tops[0] == 1) {
            left[0] = 3; // 삼각형 + 마름모2
            rigth[0] = 1; // 오른쪽 마름모
        } else {
            left[0] = 2; // 삼각형 + 마름모
            rigth[0] = 1; // 오른쪽 마름모
        }

        for (int i = 1; i < n; i++) {
            if (tops[i] == 1) {
                // 삼각형 + 마름모2 / 삼각형 + 마름모
                left[i] = (left[i - 1] * 3 + rigth[i - 1] * 2) % MOD;
            } else {
                // 삼각형 + 마름모 / 삼각형
                left[i] = (left[i - 1] * 2 + rigth[i - 1]) % MOD;
            }
            rigth[i] = (left[i - 1] + rigth[i - 1]) % MOD;
        }

        return (left[n - 1] + rigth[n - 1]) % MOD;
    }
}