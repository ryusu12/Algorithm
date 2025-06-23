class Solution
{
    public int solution(int n, int a, int b)
    {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        while (n > 2) {
            if (n / 2 >= min && n / 2 < max) return (int) (Math.log(n) / Math.log(2));
            else {
                n /= 2;
                if (min > n) {
                    min -= n;
                    max -= n;
                }
            }
        }
        return 1;
    }
}