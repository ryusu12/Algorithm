class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        sb.append(Character.toUpperCase(arr[0]));
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] == ' ') sb.append(Character.toUpperCase(arr[i]));
            else sb.append(Character.toLowerCase(arr[i]));
        }
        return sb.toString();
    }
}