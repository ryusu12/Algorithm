class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            for (char target : targets[i].toCharArray()) {
                int min = 101;
                for (String key : keymap) {
                    int idx = key.indexOf(target);
                    if (min > idx && idx != -1) min = idx;
                }
                if (min == 101) {
                    answer[i] = -1;
                    break;
                }
                else answer[i] += min + 1;
            }
        }
        return answer;
    }
}