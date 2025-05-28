class Solution {
    public int solution(String[] babbling) {
        String[] canSays = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        for (String babb : babbling) {
            int idx = 0;
            String lastWord = "";
            loop:
            while (idx < babb.length()) {
                boolean inIf = true;
                for (String canSay : canSays) {
                    if (babb.startsWith(canSay, idx)) {
                        if (canSay.equals(lastWord)) {
                            break loop;
                        }
                        idx += canSay.length();
                        lastWord = canSay;
                        inIf = false;
                        break;
                    }
                }
                if(inIf) {
                    break;
                }
            }
            if (idx == babb.length()) answer++;
        }
        return answer;
    }
}