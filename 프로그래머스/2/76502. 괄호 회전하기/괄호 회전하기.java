import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) list.add(s.charAt(i));

        // s 길이만큼 왼쪽으로 이동
        for (int i = 0; i < s.length(); i++) {
            list.add(list.get(0));
            list.remove(0);

            boolean flag = true;
            Deque<Character> deque = new ArrayDeque<>();
            for (int j = 0; j < s.length(); j++) {
                char c = list.get(j);
                if (c == '[' || c == '{' || c == '(') {
                    deque.push(c);
                } else {
                    if (deque.isEmpty()) {
                        flag = false;
                        break;
                    }
                    // ]}) 이면 있는지 확인
                    char pop = deque.pop();
                    if ((c == ']' && pop != '[') || (c == '}' && pop != '{') || (c == ')' && pop != '(')) {
                        flag = false;
                        break;
                    }
                }
            }
            // 한줄검사했는데 남은게 없으면 answer++;
            if (flag && deque.isEmpty()) answer++;
        }
        return answer;
    }
}