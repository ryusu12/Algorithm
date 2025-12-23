class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 100;
        for (int i = 0; i < wires.length; i++) {
            // v1번 송전탑을 기준으로 갈 수 있는 송전탑 개수
            int v1 = goTree(wires[i][0], i, wires, new boolean[n+1]);
            // v2 개수는 n - v1
            answer = Math.min(answer, Math.abs(v1 * 2 - n));
        }
        return answer;
    }
    
    private int goTree(int v, int idx, int[][] wires, boolean[] check) {
        check[v] = true;
        int count = 1;
        
        for (int i = 0; i < wires.length; i++) {
            if (idx == i) continue;
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            // 이동할 수 있음
            if (!check[v1] && v == v2) {
                count += goTree(v1, idx, wires, check);
            }
            if (!check[v2] && v == v1) {
                count += goTree(v2, idx, wires, check);
            }
        }
        return count;
    }
}