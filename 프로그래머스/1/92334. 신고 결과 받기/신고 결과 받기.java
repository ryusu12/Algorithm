import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> reports = new HashMap<>();
        Map<String, Integer> warn = new HashMap<>();
        Map<String, Integer> idIndex = new HashMap<>();

        // id 저장
        for(int i=0; i<id_list.length; i++) idIndex.put(id_list[i], i);

        // 신고 접수
        for (String s : report) {
            String[] req = s.split(" ");
            reports.put(req[0], reports.getOrDefault(req[0], new HashSet<>()));
            if (reports.get(req[0]).add(req[1])) {
                warn.put(req[1], warn.getOrDefault(req[1], 0) + 1);
            }
        }

        // 정지 목록 - 메일 발송
        for (String reportUser : reports.keySet()) {
            for (String target : reports.get(reportUser)) {
                if (warn.get(target) >= k) answer[idIndex.get(reportUser)]++;
            }
        }
        return answer;
    }
}