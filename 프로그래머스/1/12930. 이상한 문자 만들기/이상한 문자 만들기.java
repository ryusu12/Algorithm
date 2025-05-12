class Solution {
    public String solution(String s) {
        String answer = "";
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append(' ');
                count = 0;
                continue;
            }
            if (count % 2 == 0) {
                sb.append(Character.toUpperCase(s.charAt(i)));
            } else {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
            count++;
        }
        return sb.toString();
    }
}