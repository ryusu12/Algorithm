import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int round = 1;
        int n = cards.length;
        int idx = n/3;
        
        // 처음에 카드 뭉치에서 카드 n/3장을 뽑아 모두 가집니다
        Set<Integer> cardList = new HashSet<>();
        Set<Integer> nextList = new HashSet<>();
        for (int i = 0; i < n/3; i++) {
            cardList.add(cards[i]);
        }
        
        while(idx < n && idx + 1 < n) {
            nextList.add(cards[idx++]);
            nextList.add(cards[idx++]);
            
            // 카드 두장이 n+1이 되는지 확인
            if (check(cardList, cardList, n+1)) {
            }
            // 안되면 뽑은카드 이랑 n+1이 되는지 확인 -> 코인--;
            else if (coin >= 1 && check(cardList, nextList, n+1)) {
                coin--;
            }
            // 안되면 뽑은카드 끼리 n+1이 되는지 확인 -> 코인 -= 2;
            else if (coin >= 2 && check(nextList, nextList, n+1)) {
                coin -= 2;
            }
            // 다 안되면 게임 종료
            else {
                break;
            }
            round++;
        }
        return round;
    }
    
    private boolean check(Set<Integer> set1, Set<Integer> set2, int target) {
        for (int s : set1) {
            int need = target - s;
            if (set2.contains(need)) {
                set1.remove(s);
                set2.remove(need);
                return true;
            }
        }
        return false;
    }
}