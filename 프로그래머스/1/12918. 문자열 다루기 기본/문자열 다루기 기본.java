class Solution {
    public boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) return false;
        char[] arr = s.toCharArray();
        
        for (char word : arr) {
            if (word < '0' || word > '9') return false;
        }
        return true;
    }
}