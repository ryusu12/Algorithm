class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int idx = 0;
        int add = x;
        long num = x;
        
        while(n > 0) { 
            answer[idx++] = num;
            num += add;
            n -= 1;
        }
        return answer;
    }
}