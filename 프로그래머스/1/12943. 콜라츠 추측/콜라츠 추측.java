class Solution {
    public long solution(long num) {
        if (num == 1) {
            return 0;
        }
        for (long count = 1; count <= 500; count++) {
            if ((num % 2) == 0) {
                num /= 2;
            } else {
                num = (num * 3) + 1;
            }
            if (num == 1) {
                return count;
            }
        }
        return -1;
    }
}
