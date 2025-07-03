import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        List<String> list = Arrays.asList(want);
        int[] check = new int[number.length];

        // want 에서 idx 어딘지 확인 후, check 에 기록
        for (int start = 0; start < 10; start++) {
            int idx = list.indexOf(discount[start]);
            if (idx != -1) check[idx]++;
        }
        if (getCheck(number, check)) answer++;


        // 이동시, 앞 제거, 뒤 추가
        for (int i = 1; i + 9 < discount.length; i++) {
            int deleteIdx = list.indexOf(discount[i - 1]);
            int addIdx = list.indexOf(discount[i + 9]);
            if (deleteIdx != -1) check[deleteIdx]--;
            if (addIdx != -1) check[addIdx]++;
            if (getCheck(number, check)) answer++;
        }
        return answer;
    }

    private boolean getCheck(int[] number, int[] check) {
        for (int i = 0; i < number.length; i++) {
            if (check[i] < number[i]) return false;
        }
        return true;
    }
}