import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        // 사람 - 인덱스 매핑
        Map<String, Integer> idx = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            idx.put(friends[i], i);
        }
        
        
        // 주고받은 기록 저장
        int[][] giftLog = new int[friends.length][friends.length];
        // 선물 지수 저장
        int[] score = new int[friends.length];
        
        for (String g : gifts) {
            String[] gift = g.split(" ");
            int give = idx.get(gift[0]);
            int recive = idx.get(gift[1]);
            
            giftLog[give][recive]++;
            
            score[give]++;
            score[recive]--;
        }
        
        // 다음달에 선물 받을 수
        int[] nextGift = new int[friends.length];
        
        for (int i = 0; i < friends.length; i++) {
            for (int j = i+1; j < friends.length; j++) {
                int next = -1;
                // 주고받은 기록이 하나도 없거나 주고받은 수가 같다면
                if ((giftLog[i][j] == 0 && giftLog[j][i] == 0) || (giftLog[i][j] == giftLog[j][i])) {
                    // 선물지수 비교
                    if (score[i] > score[j]) next = i;
                    else if (score[j] > score[i]) next = j;
                    
                } else {
                    // 주고받은 기록이 있다면 더 많은 선물을 준 사람이 다음 달에 선물 받
                    next = (giftLog[i][j] > giftLog[j][i]) ? i : j;
                }
                // 다음달에 선물 받을 수[선물받을사람] ++;
                if (next != -1) {
                    nextGift[next]++;
                }
            }
        }
        
        // 다음달에 가장 많은 선물을 받는 친구가 받을 선물의 수
        Arrays.sort(nextGift);
        return nextGift[friends.length - 1];
    }
}