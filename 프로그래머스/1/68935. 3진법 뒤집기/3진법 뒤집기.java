class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; n > 0; i++) {
            sb.append(n % 3);
            n /= 3;
        }
        
        int pow = 1;
        for (int i = sb.length() - 1; i >= 0; i--) {
            answer += (sb.charAt(i) -'0') * pow;
            pow *= 3;
        }
        return answer;
    }
}