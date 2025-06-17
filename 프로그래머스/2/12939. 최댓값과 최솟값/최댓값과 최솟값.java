class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            int token = Integer.parseInt(arr[i]);
            if (min > token) min = token;
            if (max < token) max = token;
        }
        return min + " " + max;
    }
}