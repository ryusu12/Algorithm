import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>(Map.of(
                'R', 0, 'T', 0, 'C', 0, 'F', 0,
                'J', 0, 'M', 0, 'A', 0, 'N', 0
        ));

        for (int i = 0; i < survey.length; i++) {
            switch (choices[i]) {
                case 1: map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + 3); break;
                case 2: map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + 2); break;
                case 3: map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + 1); break;
                case 5: map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + 1); break;
                case 6: map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + 2); break;
                case 7: map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + 3); break;
                default: break;
            }
        }
        String answer = "";
        answer += (map.get('R') >= map.get('T')) ? 'R' : 'T';
        answer += (map.get('C') >= map.get('F')) ? 'C' : 'F';
        answer += (map.get('J') >= map.get('M')) ? 'J' : 'M';
        answer += (map.get('A') >= map.get('N')) ? 'A' : 'N';
        return answer;
    }
}