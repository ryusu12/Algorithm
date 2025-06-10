import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] termArr = term.split(" ");
            map.put(termArr[0], Integer.parseInt(termArr[1]));
        }

        String[] todayArr = today.split("\\.");
        int today0 = Integer.parseInt(todayArr[0]);
        int today1 = Integer.parseInt(todayArr[1]);
        int today2 = Integer.parseInt(todayArr[2]);

        int[] answer = new int[privacies.length];
        int idx = 0;

        for (int i = 0; i < privacies.length; i++) {
            String[] str = privacies[i].split(" ");
            String[] date = str[0].split("\\.");
            int date0 = Integer.parseInt(date[0]);
            int date1 = Integer.parseInt(date[1]) + map.get(str[1]);
            int date2 = Integer.parseInt(date[2]);

            while (date1 > 12) {
                date1 -= 12;
                date0++;
            }
            if (today0 > date0) answer[idx++] = i + 1;
            else if (today0 == date0 && today1 > date1) answer[idx++] = i + 1;
            else if (today0 == date0 && today1 == date1 && today2 >= date2) answer[idx++] = i + 1;
        }
        return Arrays.copyOf(answer, idx);
    }
}