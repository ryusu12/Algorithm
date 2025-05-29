class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] countX = new int[10];
        int[] countY = new int[10];
        
        for (char x : X.toCharArray()) countX[x - '0']++;
        for (char y : Y.toCharArray()) countY[y - '0']++;

        for (int i = 9; i >= 0; i--) {
            int min = Math.min(countX[i], countY[i]);
            for (int j = 0; j < min; j++) {
                answer.append(i);
            }
        }
        if (answer.length() == 0) return "-1";
        if (answer.charAt(0) == '0') return "0";
        return answer.toString();
    }
}