class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            sb.append(n % 3);
            n /= 3;
        }
        
        for (int i = 0; i < sb.length(); i++) {
            answer += (sb.charAt(sb.length() - i - 1)-'0') * Math.pow(3, i);
        }
        return answer;
    }
}