import java.util.*;

class Solution {
    int n = 0;
    List<int[]> combination = new ArrayList<>();
    
    public int[] solution(int[][] dice) {
        n = dice.length;
        int[] answer = new int[n / 2];
        
        // A 주사위 조합 : dfs
        getCombination(0, 0, new int[n / 2]);
        
        int maxWin = 0;
        
        for (int[] combA : combination) {
            // 나머지 조합
            int[] combB = getOtherComb(combA);
            
            // 조합에서 얻을 수 있는 결과 : dfs
            List<Integer> resultA = new ArrayList<>();
            List<Integer> resultB = new ArrayList<>();
            getResult(0, 0, combA, dice, resultA);
            getResult(0, 0, combB, dice, resultB);
                
            // 승패 확인 : 경우의수 많음 - 이분탐색
            Collections.sort(resultB);
            
            // A 돌면서 B를 이기는 경우 확인
            int win = 0;
            for (int a : resultA) {
                win += getWin(a, resultB);
            }
            // 가장 많이 이길때의 조합 리턴
            if (maxWin < win) {
                maxWin = win;
                for (int j = 0; j < n/2; j++) {
                    answer[j] = combA[j] + 1;
                }
            }
        }
        return answer;
    }
    
    private int getWin(int a, List<Integer> resultB) {
        int left = 0;
        int right = resultB.size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (a > resultB.get(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    private void getResult(int count, int sum, int[] comb, int[][] dice, List<Integer> result) {
        // 다 돌면 결과 저장
        if (count == n / 2) {
            result.add(sum);
            return;
        }
        
        for (int i = 0; i < 6; i++) {
            getResult(count + 1, sum + dice[comb[count]][i], comb, dice, result);
        }
    }
    
    private int[] getOtherComb(int[] combA) {
        int[] combB = new int[n / 2];
        
        int idxA = 0;
        int idxB = 0;
        
        for (int i = 0; i < n; i++) {
            if (idxA < n/2 && i == combA[idxA]) {
                idxA++;
                continue;
            }
            combB[idxB++] = i;
        }
        return combB;
    }
    
    private void getCombination(int now, int count, int[] comb) {
        // n/2 만큼 뽑았으면 리스트에 넣고 리턴
        if (count == n / 2) {
            combination.add(comb.clone());
            return;
        }
        
        for (int i = now; i < n; i++) {
            comb[count] = i;
            getCombination(i + 1, count + 1, comb);
        }
    }
}