import java.util.*;

class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        for (char word : arr) {
            sb.append(word);
        }
        return sb.reverse().toString();
    }
}