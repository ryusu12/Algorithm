import java.util.*;

class Solution {
    public int solution(String s) {
        String[] numberMap = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i <= 9; i++) {
           s = s.replace(numberMap[i], ""+i);
        }
        return Integer.parseInt(s);
    }
}