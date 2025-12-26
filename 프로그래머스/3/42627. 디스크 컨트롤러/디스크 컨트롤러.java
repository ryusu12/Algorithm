import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 첫 시작 : 소요시간을 기준으로 정렬
        int[][] sortJob = new int[jobs.length][3];
        for (int i = 0; i < jobs.length; i++) {
            sortJob[i][0] = jobs[i][0];
            sortJob[i][1] = jobs[i][1];
            sortJob[i][2] = i;
        }
        Arrays.sort(sortJob, (a,b) -> a[0] - b[0]);
        
        // 힙 사용 -> 매 순간마다 자동으로 갱신 진행해야함
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> {
            // 우선순위 : 소요시간이 짧은 것, 요청 시각이 빠른 것, 작업 번호가 작은 것
            if (a[1] == b[1]) {
                if (a[0] == b[0]) {
                    return a[2] - b[2];
                }
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        
        int count = jobs.length;
        int time = 0;
        int[] nowJob = null;
        int idx = 0;
        
        // 모든 작업이 완료될떄까지 반복 -> jobs 개수 차감
        while(count > 0) {
            // 시간에 맞게 큐에 넣기 - 요청시간 비교 sortJob[0]
            while (idx < sortJob.length && time == sortJob[idx][0]) {
                heap.offer(sortJob[idx++]);
            }
            
            // 다음작업 진행 -> 진행중인거 없고 대기큐에 있을때
            if (nowJob == null && !heap.isEmpty()) {
                 // 대기큐에서 다음작업 꺼내기
                nowJob = heap.poll();
            }
            
            // 현재 작업 진행
            if (nowJob != null) {
                nowJob[1]--;
                if (nowJob[1] == 0) {
                    // 완료되면? -> 작업시간이 0일때
                    // 작업 완료 개수 --;
                    // 반환시간 저장 answer += 현재시간 - 요청시간;
                    count--;
                    answer += time + 1 - nowJob[0];
                    nowJob = null;
                }
            }
            
            // 현재시간++;
            time++;
        }
        
        return answer / jobs.length;
    }
}