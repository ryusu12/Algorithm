import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        // 확실한 진법
        int N = 0;
        
        // 최소 진법 찾기 (모든 숫자 중 최대값 + 1)
        int ifN = 2;
        for (String expression : expressions) {
            for (char c : expression.toCharArray()) {
                if (Character.isDigit(c)) { 
                    ifN = Math.max(ifN, c - '0' + 1);
                }
            }
        }
        
        // 진법 찾기
        for (String expression : expressions) {
            // 공백단위로 자르기 : {첫, 부호, 둘, =, 답}
            String[] ex = expression.split(" ");
            int A = Integer.parseInt(ex[0]);
            String oper = ex[1];
            int B = Integer.parseInt(ex[2]);
            String result = ex[4];
            
            if (result.equals("X")) {
                ifN = Math.max(ifN, A%10 + 1);
                ifN = Math.max(ifN, B%10 + 1);
                continue;
            }
            
            int C = Integer.parseInt(result);
            
            if (oper.equals("-")) {
                if (A%10 < B%10) {
                    N = C%10 + B%10 - A%10;
                    break;
                } else {
                    ifN = Math.max(ifN, A%10 + 1);
                }
            }
            // 만약에 부호가 덧셈
            else {
                if (A + B == C) {
                    ifN = Math.max(ifN, A%10 + B%10 + 1);
                }
                else {
                    for (int i = 0; i < 2; i++) {
                        if (A%10 + B%10 == C%10) {
                            ifN = Math.max(ifN, A%10 + B%10 + 1);
                        }
                        // 진법 확정 == 답%10 + 첫%10 + 둘%10
                        else {
                            N = C%10 + A%10 + B%10;
                            break;
                        }
                        A /= 10;
                        B /= 10;
                        C /= 10;
                    }
                }
            }
            
        }
        
        if (ifN == 9) {
            N = 9;
        }
        
        // 계산하기
        
        List<String> resultList = new ArrayList<>();
        
        
        for (String expression : expressions) {
            // 공백단위로 자르기 : {첫, 부호, 둘, =, 답}
            String[] ex = expression.split(" ");
            String A = ex[0];
            String oper = ex[1];
            String B = ex[2];
            String result = ex[4];
            
            if (!result.equals("X")) continue;
            
            // 답이 X인거만 찾기 + 진법 확정 -- 그냥 계산하기
            if (N > 0) {
                result = calculate(A, B, oper, N);
            }
            
            // 답이 X인거만 찾기 + 진법 확정안됨
            else {
                // 가능한 진법 확인
                for (int i = ifN; i <= 9; i++) {
                    String now = calculate(A, B, oper, i);
                    if (result.equals("X")) {
                        result = now;
                    }
                    // 가능한게 여러개면 -> ?
                    if (!result.equals(now)) {
                        result = "?";
                        break;
                    }
                }
            }
            // 배열 이어붙여서 리턴하기
            resultList.add(A + " " + oper + " " + B + " " + "=" + " " + result);
        }
        
        return resultList.toArray(new String[0]);
    }
    
    private String calculate(String A, String B, String oper, int N) {
        int a = Integer.parseInt(A, N);
        int b = Integer.parseInt(B, N);
        int result = oper.equals("+") ? a + b : a - b;
        return Integer.toString(result, N);
    }
}