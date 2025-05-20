class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            for (int j = food[i] / 2; j > 0; j--) {
                sb.insert(sb.length() / 2, i + "" + i);
            }
        }
        sb.insert(sb.length() / 2, 0);
        return sb.toString();
    }
}