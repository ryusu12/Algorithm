// 바위 n개를 제거했을때, 돌 사이의 거리의 최소값, 중 가장 큰값
// 돌 사이의 거리 mid를 만족하지않는 바위수(빠지는 바위수)가 n개가 맞는지 확인

import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        // 돌 사이의 거리 범위
        int left = 1;
        int rigth = distance;
        
        while (left <= rigth) {
            int mid = (left + rigth) / 2;
            
            // 임의의 최소거리 mid을 만족하지 않는 바위 수를 구하기
            int count = 0;
            int last = 0;
            for (int i = 0; i < rocks.length; i++) {
                // 최소거리보다 더 적으면 빠지는 돌
                if (mid > rocks[i] - last) {
                    count++;
                } else {
                    last = rocks[i];
                }
            }
            if (mid > distance - last) {
                count++;
            }
            
            // 너무 많이 빠짐 : mid가 너무 큼
            if (count > n) {
                rigth = mid - 1;
            } else {
                answer = mid;
                left = mid + 1;
            }
        }
        return answer;
    }
}