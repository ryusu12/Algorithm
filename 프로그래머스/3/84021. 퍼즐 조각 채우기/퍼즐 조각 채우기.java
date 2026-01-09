import java.util.*;

class Solution {
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        
        List<List<int[]>> boardBlockList = new ArrayList<>();
        List<List<int[]>> tableBlockList = new ArrayList<>();
        
        // 빈공간 조각 구하기
        int[][] visited1 = new int[game_board.length][game_board.length];
        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board[0].length; j++) {
                if (game_board[i][j] == 0 && visited1[i][j] == 0) {
                    List<int[]> block = findBlock(i, j, 0, game_board, visited1);
                    boardBlockList.add(block);
                }
            }
        }
        
        // 퍼즐 조각 구하기
        int[][] visited2 = new int[table.length][table.length];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j] == 1 && visited2[i][j] == 0) {
                    List<int[]> block = findBlock(i, j, 1, table, visited2);
                    tableBlockList.add(block);
                }
            }
        }
        
        // 같은 도형인지 확인하기
        boolean[] used = new boolean[tableBlockList.size()];
        for (int i = 0; i < boardBlockList.size(); i++) {
            List<int[]> b = moveBlock(boardBlockList.get(i));
            for (int j = 0; j < tableBlockList.size(); j++) {
                if (used[j]) continue;
                // 같으면 채운 칸 수 저장
                List<int[]> t1 = moveBlock(tableBlockList.get(j));
                if (isSame(b, t1)) {
                    answer += b.size();
                    used[j] = true;
                    break;
                }
                // 회전 고려 : x,y -> y,-x -> 0,0 기준으로 확인
                List<int[]> t2 = turnBlock(t1);
                if (isSame(b, t2)) {
                    answer += b.size();
                    used[j] = true;
                    break;
                }
                List<int[]> t3 = turnBlock(t2);
                if (isSame(b, t3)) {
                    answer += b.size();
                    used[j] = true;
                    break;
                }
                List<int[]> t4 = turnBlock(t3);
                if (isSame(b, t4)) {
                    answer += b.size();
                    used[j] = true;
                    break;
                }
            }
        }
        return answer;
    }
    
    // 같은 도형인지 확인
    private boolean isSame(List<int[]> aList, List<int[]> bList) {
        // 크기가 다르면 F
        if (aList.size() != bList.size()) return false;
        
        // 좌표가 모두 맞으면 T
        for (int i = 0; i < aList.size(); i++) {
            if ((aList.get(i)[0] != bList.get(i)[0]) || (aList.get(i)[1] != bList.get(i)[1])) {
                return false;
            }
        }
        return true;
    }
    
    // 조각 회전하기
    private List<int[]> turnBlock(List<int[]> target) {
        List<int[]> list = new ArrayList<>();
        for (int[] t : target) {
            list.add(new int[]{t[1], -t[0]});
        }
        return moveBlock(list);
    }
    
    // 0,0 기준으로 옮기기
    private List<int[]> moveBlock(List<int[]> target) {
        Collections.sort(target, (a,b) -> a[0] - b[0]);
        int minX = target.get(0)[0];
        Collections.sort(target, (a,b) -> a[1] - b[1]);
        int minY = target.get(0)[1];
        
        List<int[]> list = new ArrayList<>();
        
        for (int[] t : target) {
            int x = t[0];
            int y = t[1];
            list.add(new int[]{x - minX, y - minY});
        }
        
        return list;
    }
    
    
    // 블럭 조각 하나 찾기 : List로 위치 저장 {x, y}, {x, y}, ...
    private List<int[]> findBlock(int startX, int startY, int find, int[][] target, int[][] visited) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int row = target.length;
        int col = target[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        visited[startX][startY] = 1;
        
        List<int[]> block = new ArrayList<>();
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            block.add(now);
            
            int x = now[0];
            int y = now[1];
            
            for (int i = 0; i < 4; i++) {
                // 찾는 대상이고, 탐색안했고, 그래프 범위 안인거
                int nx = x + dx[i];
                int ny = y + dy[i];
                boolean inRange = nx >= 0 && ny >= 0 && nx < row && ny < col;
                if(inRange && visited[nx][ny] == 0 && target[nx][ny] == find) {
                    visited[nx][ny] = visited[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return block;
    }
    
}