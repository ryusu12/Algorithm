class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String alphabet = String.valueOf(s.charAt(i));
            int idx = index;
            while (skip.contains(alphabet) || idx > 0) {
                alphabet = String.valueOf((char) ((alphabet.charAt(0) - 'a' + 1) % 26 + 'a'));
                if (!skip.contains(alphabet)) idx--;
            }
            answer.append(alphabet);
        }
        return answer.toString();
    }
}