class Solution {
    public int solution(String name) {
        int change = 0;
        int len = name.length();
        int move = len - 1;
        
        for (int i = 0; i < len; i++) {
            char n = name.charAt(i);
            // 위 아래 이동 숫자 비교해서 작은 값으로 : min(B - A, Z - B + 1)
            if (n != 'A') {
                change += Math.min(n - 'A', 'Z' - n + 1);
            }
            
            int j = i + 1;
            for (; j < len && name.charAt(j) == 'A'; j++) {}
            
            // 한방향으로 가기 - 기본
            // 오른쪽 A까지-> 왼쪽 A까지 : (A시작) * 2 + (len - A끝)
            // 왼쪽 A까지 -> 오른쪽 A까지 : (len - A끝) * 2 + (A시작)
            move = Math.min(move, i * 2 + len - j);
            move = Math.min(move, (len - j) * 2 + i);
        }
        return change + move;
    }
}