import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int len = number.length();
        int delete = 0;
        
        for (int i = 0; i < len; i++) {
            // 비교 후 제거 과정 : 최근에넣은것 < 넣을것 ? 최근에넣은것 제거
            // k만큼 제거하면 : 제거과정 끝내기 ~ 나머지 부분 다 넣기
            char n = number.charAt(i);
            while (!stack.isEmpty() && delete < k && stack.peek() < n) {
                stack.pop();
                delete++;
            }
            stack.add(n);
        }
        
        // Stack -> String
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            // 내림차순 숫자일때 : 9876
            if (sb.length() == len - k) break;
            sb.append(c);
        };
        return sb.toString();
    }
}