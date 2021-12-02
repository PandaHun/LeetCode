class Solution {
    public int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];
        for (int r = 0 ; r < m ; r++) {
            for (int c = 0; c < n; c++) {
                if (r == 0 || c == 0) {
                    map[r][c] = 1;
                    continue;
                }
                map[r][c] = map[r - 1][c] + map[r][c - 1];
            }
        }
        return map[m - 1][n - 1];
    }
}