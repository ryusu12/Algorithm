class Solution {
    public long solution(long n) {
        String str = "" + n;
        char[] arr = str.toCharArray();

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    char tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        String answer = "";
        for (char word : arr) {
            answer += word;
        }

        return Long.parseLong(answer);
    }
}