import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int i : ingredient) {
            list.add(i);
            if (list.size() >= 4) {
                int val1 = list.get(list.size() - 4);
                int val2 = list.get(list.size() - 3);
                int val3 = list.get(list.size() - 2);
                int val4 = list.get(list.size() - 1);
                if ((val1 == 1) && (val2 == 2) && (val3 == 3) && (val4 == 1)) {
                    list.subList(list.size() - 4, list.size()).clear();
                    answer++;
                }
            }
        }
        return answer;
    }
}