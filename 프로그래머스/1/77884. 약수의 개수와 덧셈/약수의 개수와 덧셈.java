class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int num = left;
        while(num <= right) {
            int count = 0;
            for (int i = 1; i<= Math.sqrt(num); i++) {
                if(num % i == 0) {
                    count += (i == num / i) ? 1 : 2;
                }
            }
            if(count % 2 == 0) {
                answer += num;
            } else {
                answer -= num;
            }
            num++;
        }
        return answer;
    }
}