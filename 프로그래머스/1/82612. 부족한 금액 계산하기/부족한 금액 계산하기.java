class Solution {
    public long solution(int price, int money, int count) {
        long counts = 0;
        for (int i = 1; i <= count; i++) {
            counts += i;
        }
        return ((counts * price - money) < 0) ? 0 : counts * price - money;
    }
}