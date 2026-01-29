class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
                
        // 시간을 초단위로 바꾸기
        int nowTime = s1 + m1*60 + h1*60*60;
        int endTime = s2 + m2*60 + h2*60*60;
        
        // 1초마다 반복
        double[] lastD = change(nowTime);
        
        // 시작 시각에 겹쳐 있는지 확인
        if (lastD[0] == lastD[2]) answer++;
        if (lastD[1] == lastD[2] && lastD[1] != lastD[0]) answer++;
    
        
        for (int t = nowTime + 1; t <= endTime; t++) {
            double[] nowD = change(t);
            
            double nH = nowD[0] == 0 ? 360 : nowD[0];
            double nM = nowD[1] == 0 ? 360 : nowD[1];
            double nS = nowD[2] == 0 ? 360 : nowD[2];
            
            // 이전 초각도 < 이전 시각도 && 지금 초각도 > 지금 시각도 : 추월
            if (lastD[0] > lastD[2] && nH <= nS) {
                answer++;
            }
            // 분 겹침 + 동시에 겹치면 한번만 알람
            if (!(nowD[1] == nowD[0]) && lastD[1] > lastD[2] && nM <= nS) {
                answer++;
            }
            lastD = nowD;
        }

        return answer;
    }
    
    // 시분초 -> 이동거리로 변환
    private double[] change(int time) {
        // 12시간으로 변경
        int t = time % (12*60*60);
        
        double hD = (t * (1.0 / 120)) % 360;
        double mD = (t * 0.1) % 360;
        double sD = (t * 6.0) % 360;
        
        return new double[] {hD, mD, sD};
    }
}