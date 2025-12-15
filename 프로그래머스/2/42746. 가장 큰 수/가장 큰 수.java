import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 문자열로 numbers
        String[] strArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = numbers[i] + "";
        }
        // 문자열 상태로 정렬 (3, 30 -> 330 <> 303)
        Arrays.sort(strArr, ((a, b) -> (b+a).compareTo(a+b)));
        
        // 예외 : 앞이 0이면 -> 0 (1000 / 000)
        if (strArr[0].equals("0")) return "0";
        
        // 이어 붙이기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(strArr[i]);
        }
        return sb.toString();
    }
}