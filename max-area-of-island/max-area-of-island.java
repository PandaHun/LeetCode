class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        Queue<int[]> q = new LinkedList<>();
        int ret = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    q.add(new int[]{r, c});
                    grid[r][c] = 0;
                    int count = 1;
                    while (!q.isEmpty()) {
                        int[] now = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int nr = now[0] + dr[k];
                            int nc = now[1] + dc[k];
                            if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] == 0) {
                                continue;
                            }
                            q.add(new int[]{nr, nc});
                            grid[nr][nc] = 0;
                            count += 1;
                        }
                    }
                    ret = Math.max(ret, count);
                }
            }
        }
        return ret;
    }
}