class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] now = {};
        // s 위치 찾기
        for (int y = 0; y < park.length; y++) {
            for (int x = 0; x < park[0].length(); x++) {
                if (park[y].charAt(x) == 'S') {
                    now = new int[]{y, x};
                    break;
                }
            }
        }
        // 이동
        for (String route : routes) {
            int X = now[1];
            int Y = now[0];
            String[] move = route.split(" ");
            boolean canMove = true;
            for (int i = 0; i < Integer.parseInt(move[1]); i++) {
                switch (move[0]) {
                    case "E" -> X++;
                    case "W" -> X--;
                    case "S" -> Y++;
                    case "N" -> Y--;
                }
                if (X < 0 || Y < 0 || (X > park[0].length() - 1) || (Y > park.length - 1) || park[Y].charAt(X) == 'X') {
                    canMove = false;
                    break;
                }
            }
            if (canMove) {
                now[1] = X;
                now[0] = Y;
            }
        }
        return now;
    }

}