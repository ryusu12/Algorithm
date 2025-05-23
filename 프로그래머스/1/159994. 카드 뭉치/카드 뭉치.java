class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int a = 0, b = 0;
        for (int i = 0; i < goal.length; i++) {
            if (a < cards1.length && goal[i].equals(cards1[a])) {
                a++;
            } else if (b < cards2.length && goal[i].equals(cards2[b])) {
                b++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}