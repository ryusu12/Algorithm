class Solution {
    Character[] alpha = {'A', 'E', 'I', 'O', 'U'};
    int count = 0;
    boolean flag = false;
    
    public int solution(String word) {
        makeAlphabet(word, "");
        return count;
    }
    
    private void makeAlphabet(String word, String makedWord) {
        if (word.equals(makedWord)) {
            flag = true;
            return;
        }
        
        if (makedWord.length() == 5) return;
        
        for (int i = 0; i < alpha.length; i++) {
            if (!flag) {
                count++;
                makeAlphabet(word, makedWord + alpha[i]);
            }
        }
    }
    
}