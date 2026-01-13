// i번을 사용해서 만든것 = (j번을 사용해서 만든것) 사칙 (i-j번을 사용해서 만든것) - set으로저장
// SET으로 저장한것중 number가 있으면 i 리턴

import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // i 번 사용할 수 있는 모든 경우의 수
        List<Set<Integer>> list = new ArrayList<>();
        
        for (int i = 1; i <= 8; i++) {
            Set<Integer> set = new HashSet<>();
            int NN = Integer.parseInt(String.valueOf(N).repeat(i));
            set.add(NN);
            // 사칙연산 사용
            for (int j = 1; j < i; j++) {
                for (int a : list.get(j - 1)) {
                    for (int b : list.get(i - j - 1)) {
                        set.add(a + b);
                        set.add(a - b); 
                        set.add(a * b);
                        if (b != 0) set.add(a / b);
                    }
                }
            }
            if (set.contains(number)) return i;
            list.add(set);
        }
        
        return -1;
    }
}