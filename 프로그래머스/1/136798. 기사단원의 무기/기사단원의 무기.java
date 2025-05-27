class Solution {
    public int getDivisor(int num) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                count += (num / i == i) ? 1 : 2;
            }
        }
        return count;
    }
    
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int divisor = getDivisor(i);
            if (divisor > limit) divisor = power;
            answer += divisor;
        }
        return answer;
    }
}