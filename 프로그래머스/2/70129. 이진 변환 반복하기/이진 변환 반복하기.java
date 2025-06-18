class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")) {
            StringBuilder sb = new StringBuilder();
            StringBuilder result = new StringBuilder();

            // 모든 0을 제거
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '0') answer[1]++;
                else sb.append(s.charAt(i));
            }

            // c를 2진법으로 표현
            int c = sb.length();
            while (c > 0) {
                result.append(c % 2);
                c /= 2;
            }
            
            s = result.reverse().toString();
            answer[0]++;
        }
        return answer;
    }
}