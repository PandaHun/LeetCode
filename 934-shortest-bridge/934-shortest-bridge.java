class Solution {
    Queue<int[]> q;
    boolean[][] visited;
    int[] dr, dc;
    int r, c;
    
    public int shortestBridge(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        q = new LinkedList<>();
        visited = new boolean[r][c];
        dr = new int[]{0, 0, -1, 1};
        dc = new int[]{1, -1, 0, 0};
        
        boolean flag = false;
        
        for (int i = 0; i < r; i++) {
            if (flag) {
                break;
            }
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i , j);
                    flag = true;
                    break;
                }
            }
        }
        int len = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] now = q.poll();
                for (int k = 0; k < 4; k++) {
                    int nr = now[0] + dr[k];
                    int nc = now[1] + dc[k];
                    if (nr >= 0 && nc >= 0 && nr < r && nc < c && !visited[nr][nc]) {
                        if (grid[nr][nc] == 1) {
                            return len;
                        }
                        q.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            len++;
        }
        return -1;
    }
    
    void dfs(int[][] grid, int i, int j) {
        if ( i < 0 || j < 0 || i >= r || j >= c || visited[i][j] || grid[i][j] == 0)  {
            return;
        }
        visited[i][j] = true;
        q.offer(new int[]{i, j});
        for (int k = 0; k < 4; k++) {
            dfs(grid, i + dr[k], j + dc[k]);
        }
    }
}