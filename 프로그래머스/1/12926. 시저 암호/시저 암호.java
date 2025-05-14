class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);
            if (word == ' ') sb.append(word);
            else if (word >= 'A' && word <= 'Z') sb.append((char)((word + n - 'A') % 26 + 'A'));
            else if (word >= 'a' && word <= 'z') sb.append((char)((word + n - 'a') % 26 + 'a'));
        }
        return sb.toString();
    }
}