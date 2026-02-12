class Solution {
    public int[] solution(int[][] edges) {
        // 생성한 정점의 번호, 도넛 모양 그래프의 수, 막대 모양 그래프의 수, 8자 모양 그래프의 수
        int[] answer = new int[4];

        // 노드 최대값 구하기
        int maxNode = 1000000;
        for (int i = 0; i < edges.length; i++) {
            maxNode = Math.max(maxNode, Math.max(edges[i][0], edges[i][1]));
        }
        
        // int[][] node {진입수, 진출수}
        int[][] node = new int[maxNode + 1][2];
        for (int i = 0; i < edges.length; i++) {
            node[edges[i][0]][0]++;
            node[edges[i][1]][1]++;
        }
        
        for (int i = 1; i <= maxNode; i++) {
            int out = node[i][0];
            int in = node[i][1];

            if (node[i][0] >= 2 && node[i][1] == 0) {
                // 정점 : 진입 0
                answer[0] = i;
            } else if (node[i][0] == 0 && node[i][1] >= 1) {
                // 막대 : 마지막 노드가 진출 0
                answer[2]++;
            } else if (out == 2 && in >= 2) {
                // 8자 : 집입, 진출이 2인게 있을때
                answer[3]++;
            }
        }
        
        answer[1] = node[answer[0]][0] - answer[2] - answer[3];
        return answer;
    }

}