class Solution {
    public int solution(String s) {
        int answer = 0;
        int same = 0;
        int defferent = 0;
        int x = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(x) == s.charAt(i)) {
                same++;
            } else {
                defferent++;
            }
            if (same == defferent) {
                answer++;
                x = i + 1;
            } else if (i == s.length() - 1) answer++;
        }
        return answer;
    }
}