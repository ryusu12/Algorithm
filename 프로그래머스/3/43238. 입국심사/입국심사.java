// 주어진 값의 크기가 매우 큼 : 이분탐색
// answer 분의 시간 동안 n명을 심사할 수 있는지 확인하기
// 임의의 시간 now 분의 시간 동안 최대 몇명 sum 을 심사할 수 있는지 확인
// sum >= n명 ? 시간 충분 : 최대값 줄이기 - 이때 최소값인 경우 answer
// sum < n명 ? 시간 부족 : 최소값 늘리기
// 탐색 기준 mid : 시간을 늘리고 줄이는 기준 = 모두 심사를 마치는데 필요한 최소값(times 최소) + 최대값(times 최대 * n) / 2

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long left = times[0];
        long right = (long) times[times.length - 1] * n;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            // 최대 몇명 sum 을 심사할 수 있는지 확인
            for (int time : times) {
                sum += mid / time;
            }
            // mid 조절
            if (sum >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}