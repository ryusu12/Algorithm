class Solution {
    public int solution(int[] money) {
        // 첫번째 집 털경우
        int[] map1 = new int[money.length];
        map1[0] = money[0];
        map1[1] = Math.max(money[0], money[1]);
        for (int i = 2; i < money.length -1; i++) {
            map1[i] = Math.max(map1[i-1], money[i] + map1[i - 2]);
        }
        
        // 첫번째 집 털경우
        int[] map2 = new int[money.length];
        map2[0] = 0;
        map2[1] = money[1];
        for (int i = 2; i < money.length; i++) {
            map2[i] = Math.max(map2[i-1], money[i] + map2[i - 2]);
        }
        
        return Math.max(map2[money.length - 1], map1[money.length - 2]);
    }
}