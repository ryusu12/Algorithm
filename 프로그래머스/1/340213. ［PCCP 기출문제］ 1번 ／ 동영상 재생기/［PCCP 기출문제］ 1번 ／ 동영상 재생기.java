class Solution {
    
    // : 기준으로 나누고, Int[]로 변환
    private int[] formatTime(String target) {
        int[] result = new int[2];
        int idx = 0;
        for (String s : target.split(":")) {
            result[idx++] = Integer.parseInt(s);
        }
        return result;
    }
    
    // 오프닝 구간인지 확인
    private int[] isOp(int[] now, int[] op_s, int[] op_e) {
        // op_start ≤ 계산값 ≤ op_end ? op_end 로 이동
        boolean start = (op_s[0] < now[0]) || (op_s[0] == now[0] && op_s[1] <= now[1]);
        boolean end = (op_e[0] > now[0]) || (op_e[0] == now[0] && op_e[1] >= now[1]);
        if (start && end) {
            now[0] = op_e[0];
            now[1] = op_e[1];
        }
        
        return now;
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        // 시작부터 int형으로 바꾸기
        int[] video = formatTime(video_len);
        int[] now = formatTime(pos);
        int[] op_s = formatTime(op_start);
        int[] op_e = formatTime(op_end);
        
        // 시간 이동
        for (int i = 0; i < commands.length; i++) {
            
            now = isOp(now, op_s, op_e);
            
            if (commands[i].equals("prev")) now[1] -= 10;
            if (commands[i].equals("next")) now[1] += 10;
            
            // 분초 시간 조절
            int s = now[1];
            if (s >= 60) {
                now[0] += s / 60;
                now[1] = s % 60;
            }
            else if (s < 0) {
                now[0] -= 1;
                now[1] = 60 + s;
            } 
            else {
                now[1] = s;
            }
            
            // 남은 시간이 10초 미만일 경우(계산값이 마지막보다 클때) 영상의 마지막 위치로 이동
            if ((now[0] > video[0]) || (now[0] == video[0] && now[1] > video[1])) {
                now[0] = video[0];
                now[1] = video[1];
            }
            // 10초 미만인 경우(계산값이 음수) 영상의 처음 위치로 이동
            if (now[0] < 0) {
                now[0] = 0;
                now[1] = 0;
            }
            now = isOp(now, op_s, op_e);
        }
        now = isOp(now, op_s, op_e);
        
        // mm:ss 형식으로 변환
        String mm = "";
        String ss = "";
        if (now[0] >= 0 && now[0] <= 9) {
            mm = "0" + now[0];
        } else {
            mm = "" + now[0];
        }
        
        if (now[1] >= 0 && now[1] <= 9) {
            ss = "0" + now[1];
        } else {
            ss = "" + now[1];
        }
        
        return mm + ":" + ss;
    }
}