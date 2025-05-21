class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while (n >= a) {
            int min = n - (n % a);
            int add = (min / a) * b;
            answer += add;
            n = n - min + add;
        }
        return answer;
    }
}