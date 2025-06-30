import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        // 구간합
        List<Integer> sum = new ArrayList<>();
        sum.add(0);
        for (int i = 0; i < elements.length; i++) {
            sum.add(sum.get(i) + elements[i]);
            set.add(elements[i]);
        }
        
        int num = 2;
        int idx = 0;
        while (num <= elements.length) {
            sum.add(sum.get(sum.size() - 1) + elements[idx++]);
            for (int i = num; i < sum.size(); i++) {
                set.add(sum.get(i) - sum.get(i - num));
            }
            num++;
        }

        return set.size();
    }
}