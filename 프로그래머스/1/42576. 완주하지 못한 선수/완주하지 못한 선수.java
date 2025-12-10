import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // completion를 탐색했는지 아닌지 => map<이름, 인원수>
        Map<String, Integer> check = new HashMap<>();
        for (int i = 0; i < completion.length; i++) {
            int num = check.getOrDefault(completion[i], 0);
            check.put(completion[i], num + 1);
        }
        
        for (int i = 0; i < participant.length; i++) {
            int num = check.getOrDefault(participant[i], 0);
            // 있으면 인원수-1
            if (num > 0) {
                check.put(participant[i], num - 1);
            } else {
                // 없으면(인원수 0) return
                answer = participant[i];
                break;
            }
            
        }
        return answer;
    }
}