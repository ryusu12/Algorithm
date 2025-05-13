class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        Long numP = Long.parseLong(p);
        for(int i = 0; i + len < t.length()+1; i++) {
            Long num = Long.parseLong(t.substring(i, i + len));
            if (num <= numP) answer++;
        }
        return answer;
    }
}