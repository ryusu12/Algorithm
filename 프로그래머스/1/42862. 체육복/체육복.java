import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> reserveList = new ArrayList<>();
        List<Integer> lostList = new ArrayList<>();
        for (int i : reserve) reserveList.add(i);

        for (int los : lost) {
            if (!reserveList.remove(Integer.valueOf(los))) lostList.add(los);
        }
        
        reserveList.sort((a, b) -> a - b);
        lostList.sort((a, b) -> a - b);

        int lostNum = lostList.size();
        for (int los : lostList) {
            if (reserveList.remove(Integer.valueOf(los))) lostNum--;
            else if (reserveList.remove(Integer.valueOf(los - 1))) lostNum--;
            else if (reserveList.remove(Integer.valueOf(los + 1))) lostNum--;
        }
        return n - lostNum;
    }
}