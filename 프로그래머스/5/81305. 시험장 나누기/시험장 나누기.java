class Solution {
    int count = 1;
    
    private int findRoot(int[][] links) {
        boolean[] hasChild = new boolean[links.length];
        for (int i = 0; i < links.length; i++) {
            if (links[i][0] != -1) hasChild[links[i][0]] = true;
            if (links[i][1] != -1) hasChild[links[i][1]] = true;
        }
        
        for (int i = 0; i < links.length; i++) {
            if (!hasChild[i]) {
                return i;
            }
        }
        return -1;
    }
    
    public int solution(int k, int[] num, int[][] links) {
        int answer = 0;
        
        // 루트 노드 인덱스 - 자식노드로 언급 안된거
        int root = findRoot(links);
        
        // 이분탐색 - 그룹크기 / 최소 : 인원 최대값 30 / 최대 : 모두 합한 값
        int left = 0;
        int right = 0;
        for (int n : num) {
            left = Math.max(left, n);
            right += n;
        }
        
        while (left <= right) {
            int mid = (left + right) / 2;
            count = 1;
            // dfs - 그룹수 구하기 : 후위 순회
            dfs(root, mid, num, links);
            //그룹을 너무 많이 나눠버림 : 그룹 인원 수 증가
            if (count > k) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    private int dfs(int root, int mid, int[] num, int[][] links) {
        // 후위순회 - 자식들 크기
        int left = (links[root][0] != -1) ? dfs(links[root][0], mid, num, links) : 0;
        int right = (links[root][1] != -1) ? dfs(links[root][1], mid, num, links) : 0;
        
        
        // 안끊을때
        if (num[root] + left + right <= mid) {
            return num[root] + left + right;
        }
        
        // 현재-양옆 > 기준 : 더 큰 자식 끊기 현재+min(양옆)
        if (num[root] + Math.min(left, right) <= mid) {
            count++; // 그룹 나뉨
            return num[root] + Math.min(left, right);
        }
        
        // 둘다 끊어야함
        count += 2;
        return num[root];
    }
}