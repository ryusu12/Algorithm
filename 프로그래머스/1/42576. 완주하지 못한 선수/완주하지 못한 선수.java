import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for (int i = 0; i < completion.length; i++) {
            // 틀리면 participant가 완주 못함
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        // 차이없으면 마지막 남은 사람이 완주 못함
        return participant[participant.length - 1];
    }
}
