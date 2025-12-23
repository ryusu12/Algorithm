class Solution {
    private int answer = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] check = new boolean[dungeons.length];
        intoDungeon(k, dungeons, check, 0);
        return answer;
    }
    
    private void intoDungeon(int now, int[][] dungeons, boolean[] check, int count) {
        // 매번 최대값 갱신
        answer = Math.max(answer, count);
        
        for (int i = 0; i < dungeons.length; i++) {
            // 입장 가능 -> 현재 -= 피로도 / 체크 -> 다음 던전 입장 -> 체크 해제
            if (check[i] == false && now >= dungeons[i][0]) {
                check[i] = true;
                intoDungeon(now - dungeons[i][1], dungeons, check, count + 1);
                check[i] = false;
            }
            // 입장 불가능 -> 끝
        }
    }
}