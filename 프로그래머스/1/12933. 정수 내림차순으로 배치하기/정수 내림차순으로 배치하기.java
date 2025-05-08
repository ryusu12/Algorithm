import java.util.*;

class Solution {
    public long solution(long n) {
        char[] arr = ("" + n).toCharArray();
        Arrays.sort(arr);

        StringBuilder answer = new StringBuilder(new String(arr));
        return Long.parseLong(answer.reverse().toString());
    }
}