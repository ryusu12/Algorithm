import java.util.*;

class Solution {
    private Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        makeNumber("", numbers);
        return set.size();
    }
    
    // 숫자 만들기
    private void makeNumber(String now, String remain) {
        if (!now.equals("")) {
            int number = Integer.parseInt(now);
            // 0, 1은 제외 + 소수가 아니면 제외
            if ((number != 0) && (number != 1) && checkIsPrime(now)) {
                set.add(Integer.parseInt(now));
            };
        }
        for (int i = 0; i < remain.length(); i++) {
            makeNumber(now + remain.charAt(i), remain.substring(0, i) + remain.substring(i + 1));
        }
    }
    
    // 소수 판별 - 1과 자신일때: 제곱근까지 판별
    private boolean checkIsPrime(String now) {
        int number = Integer.parseInt(now);
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number%i == 0 && i != 1) {
                // 약수가 1과 자신이 아닐때
                return false;
            }
        }
        // 소수일 때
        return true;
    }
}
