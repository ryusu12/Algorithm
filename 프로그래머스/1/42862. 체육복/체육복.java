import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();
        for (int r : reserve) reserveList.add(r);
        
        // 사전 처리 : 여벌 있는 학생이 도난당한 경우 - 빌려줄 수 없음
        for (int lst : lost) {
            int idx = reserveList.indexOf(lst);
            if (idx != -1) {
                reserveList.remove(idx);
            } else {
                lostList.add(lst);
            }
        }
        
        // 체격순으로 정렬하기
        Collections.sort(reserveList);
        Collections.sort(lostList);
        
        // lost의 전후 값이 reserve에 있는지? 전부터 검사
        for (int lst : lostList) {
            int frontIdx = reserveList.indexOf(lst - 1);
            int backIdx = reserveList.indexOf(lst + 1);
            if (frontIdx != -1) {
                reserveList.remove(frontIdx);
                continue;
            }
            else if (backIdx != -1) {
                reserveList.remove(backIdx);
                continue;
            } else {
                answer--;
            }
        }
        
        return answer;
    }
}