class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int hp = health;
        int time = 0;
        int healTime = 0;
        int success = 0;
        
        int attacksIdx = 0;
        
        while (attacksIdx < attacks.length) {
            // 시간흐름
            time++;
            
            // 몬스터의 공격을 받으면
            if (time == attacks[attacksIdx][0]) {
                healTime = 0;
                hp -= attacks[attacksIdx][1];
                success = 0;
                attacksIdx++;
            }
            
            // 공격받지 않으면 체력회복하기
            else {
                hp += bandage[1];
                healTime++;
                success++;
                if (success >= bandage[0]) {
                    hp += bandage[2];
                    success = 0;
                }
            }
            
            // 최대채력 제한
            if (hp >= health) {
                hp = health; // 혹시 넘게된다면 최대로 고정
                healTime = 0;
                success++;
            }
            
            // 현재 체력이 0 이하가 되면
            if (hp <= 0) return -1;            
        }
        
        return hp;
    }
}