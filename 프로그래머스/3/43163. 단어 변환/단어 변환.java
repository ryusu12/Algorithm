import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        // word에 없으면 0
        if (!Arrays.asList(words).contains(target)) return answer;
        
        Queue<String> que = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        // 첫번째
        que.offer(begin);
        int count = 0;

        // 탐색
        while (!que.isEmpty()) {
            // 바꿀수 있는 단어들
            for (int i = 0; i < que.size(); i++) {
                String now = que.poll();
                
                // begin == target ? 몇번거쳤는지 리턴하고 종료
                if (now.equals(target)) return count;
                
                // 한글자만 다른거 고르기
                for (String word : words) {
                    // 한글자만 다른지 확인
                    int diff = 0;
                    for (int j = 0; j < now.length(); j++) {
                        if (now.charAt(j) != word.charAt(j)) diff++;
                    }
                    // 탐색한적 없고, 한글자만 다르면 고르기
                    if (!visited.contains(word) && diff==1) {
                        visited.add(word);
                        que.offer(word);
                    }
                }
            }
            count++;
        }
        
        return answer;
    }
}