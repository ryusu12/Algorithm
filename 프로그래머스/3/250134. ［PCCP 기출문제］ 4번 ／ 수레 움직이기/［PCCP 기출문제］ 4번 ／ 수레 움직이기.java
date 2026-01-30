import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    
    int x, y;
    boolean[][] visitedR, visitedB;
    
    int[] endR = new int[2];
    int[] endB = new int[2];
    
    int dy[] = {-1, 1, 0, 0};
    int dx[] = {0, 0, -1, 1};
    
    public int solution(int[][] maze) {
        
        y = maze.length;
        x = maze[0].length;
        
        int[] startR = new int[2];
        int[] startB = new int[2];
        
        visitedR = new boolean[y][x];
        visitedB = new boolean[y][x];
        
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (maze[i][j] == 1) startR = new int[] {i, j};
                else if (maze[i][j] == 2) startB = new int[] {i, j};
                else if (maze[i][j] == 3) endR = new int[] {i, j};
                else if (maze[i][j] == 4) endB = new int[] {i, j};
            }
        }
        
        visitedR[startR[0]][startR[1]] = true;
        visitedB[startB[0]][startB[1]] = true;
        
        bfs(startR, startB, maze, 0);
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    private void bfs(int[] nowR, int[] nowB, int[][] maze, int count) {
        // 도착하면 끝내기
        if (count >= answer) return;
        
        boolean finishR = nowR[0] == endR[0] && nowR[1] == endR[1];
        boolean finishB = nowB[0] == endB[0] && nowB[1] == endB[1];
        if (finishR && finishB) {
            answer = Math.min(answer, count);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // 이동 : 도착하면 변함없음
                int nxR = (finishR) ? nowR[1] : nowR[1] + dx[i];
                int nyR = (finishR) ? nowR[0] : nowR[0] + dy[i];
                
                int nxB = (finishB) ? nowB[1] : nowB[1] + dx[j];
                int nyB = (finishB) ? nowB[0] : nowB[0] + dy[j];
                
                // 범위내, 벽 아님, (종료하지 않을때)탐색안한곳, 같은 위치 아님, 자리바꾸면 안됨
                boolean inRangeR = nxR >= 0 && nyR >= 0 && nxR < x && nyR < y;
                boolean inRangeB = nxB >= 0 && nyB >= 0 && nxB < x && nyB < y;
                if (!inRangeR || !inRangeB) continue;
                if (maze[nyR][nxR] == 5 || maze[nyB][nxB] == 5) continue;
                
                boolean visited = (!finishR && visitedR[nyR][nxR]) || (!finishB && visitedB[nyB][nxB]);
                boolean same = nxR == nxB && nyR == nyB;
                boolean change = (nxR == nowB[1] && nyR == nowB[0]) && (nxB == nowR[1] && nyB == nowR[0]);
                if (visited || same || change) continue;
                
                visitedR[nyR][nxR] = true;
                visitedB[nyB][nxB] = true;
                bfs(new int[] {nyR, nxR}, new int[] {nyB, nxB}, maze, count + 1);
                if (!finishR) visitedR[nyR][nxR] = false;
                if (!finishB) visitedB[nyB][nxB] = false;
            }
        }
    }
}