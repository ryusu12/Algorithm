import java.util.*;

class Solution {
    boolean solution(String s) {
        // 처음부터 ) 이면 return false
        if (s.charAt(0) == ')') return false;
        // 마지막이 ( 이면 return false
        if (s.charAt(s.length() - 1) == '(') return false;
        
        // 큐
        Queue<Character> que = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            // peek 가 ( 이고, 들어갈게 ) 면 -> pop
            if (!que.isEmpty() && que.peek() == '(' && s.charAt(i) == ')') {
                que.poll();
            } else {
                // 아니면 push
                que.offer(s.charAt(i));
            }
            
        }
        // 모두 진행했을때, 비어있으면 true, 아니면 false
        if (que.isEmpty()) {
            return true;
        }
        return false;
    }
}